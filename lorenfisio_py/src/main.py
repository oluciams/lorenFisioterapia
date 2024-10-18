import pandas as pd 
import  mysql.connector
from tabulate import tabulate
from datetime import datetime
import matplotlib.pyplot as plt
import numpy as np


connection = mysql.connector.connect(
    host="localhost",
    user="",
    password="",
    database="physiotherapy_bd"
)

df_user=pd.read_sql("select * from user", connection)
df_appointment=pd.read_sql("select * from appointment", connection)
df_employee=pd.read_sql("select * from employee", connection)
df_package=pd.read_sql("select * from package", connection)
df_user_package = pd.read_sql("select * from user_package", connection)
df_employee_appointment = pd.read_sql("select * from employee_appointment", connection)
df_user_appointment = pd.read_sql("SELECT * FROM user_appointment", connection)


print(tabulate(df_user))
print(tabulate(df_appointment, headers='keys'))
print(tabulate(df_employee))
print(tabulate(df_package, headers='keys'))


print(df_user.describe())
print(df_package.describe())

consulta_eps_sanitas = df_user.query("insurance_entity == 'EPS Sanitas'")
consulta_eps_sanitas=consulta_eps_sanitas[['user_first_name', 'user_second_name', 'user_last_name', 'user_second_last_name', 'insurance_entity']]
print(consulta_eps_sanitas)

consulta_eps_sura = df_user.query("insurance_entity == 'EPS Sura'")
consulta_eps_sura=consulta_eps_sura[['user_first_name', 'user_second_name', 'user_last_name', 'user_second_last_name', 'insurance_entity']]
print(consulta_eps_sura)


consulta_eps_coomeva = df_user.query("insurance_entity == 'Coomeva'")
consulta_eps_coomeva=consulta_eps_coomeva[['user_first_name', 'user_second_name', 'user_last_name', 'user_second_last_name', 'insurance_entity']]
print(consulta_eps_coomeva)

consulta_eps_otras = df_user.query("insurance_entity != 'EPS Sura' & insurance_entity != 'EPS Sanitas' & insurance_entity != 'Coomeva' ")
consulta_eps_otras=consulta_eps_otras[['user_first_name', 'user_second_name', 'user_last_name', 'user_second_last_name', 'insurance_entity']]
print(consulta_eps_otras)


consulta_cantidad_eps = df_user.groupby('insurance_entity').size()
print(consulta_cantidad_eps)

max_precio_id = df_package['session_price'].idxmax()
min_precio_id = df_package['session_price'].idxmin()

max_precio_package = df_package.loc[max_precio_id]
min_precio_package = df_package.loc[min_precio_id]

promedio_precio = df_package['session_price'].mean()
print(f"El precio promedio de los paquetes es: {promedio_precio:.2f}")

print("Paquete con el precio más alto:")
print(f"Nombre: {max_precio_package['package_name']}, Precio: ${max_precio_package['session_price']}")

print("\nPaquete con el precio más bajo:")
print(f"Nombre: {min_precio_package['package_name']}, Precio: ${min_precio_package['session_price']}")


def calcular_edad(fecha_nacimiento):
    hoy = datetime.today()
    edad = hoy.year - fecha_nacimiento.year -((hoy.month, hoy.day) < (fecha_nacimiento.month, fecha_nacimiento.day))
    return edad

df_user['user_birthdate'] = pd.to_datetime(df_user['user_birthdate'])
df_user['edad'] = df_user['user_birthdate'].apply(calcular_edad)
conteo_edades = df_user['edad'].value_counts()
promedio_edades = df_user['edad'].mean()

print(df_user[['user_first_name', 'user_last_name', 'user_birthdate', 'edad']])

print("Conteo de personas por edad:")
print(conteo_edades)

print("\nPromedio de edad:")
print(f"{promedio_edades:.2f} años")

edades_por_eps = df_user.groupby('insurance_entity')['edad'].apply(list)
print("Edades por EPS:")
print(edades_por_eps)

promedio_edades_eps = df_user.groupby('insurance_entity')['edad'].mean().round(1)
print("Promedio de edades por EPS:")
print(promedio_edades_eps)


conteo_eps = df_user['insurance_entity'].value_counts()
print("Cantidad de usuarios por EPS:")
print(conteo_eps)

plt.figure(figsize=(10, 6))

conteo_eps.plot(kind='bar', color='purple')
plt.title('Cantidad de Usuarios por EPS')
plt.xlabel('EPS')
plt.ylabel('Cantidad de Usuarios')
plt.xticks(rotation=45) 

plt.savefig('pers_eps.png', bbox_inches='tight')  
plt.close() 

df_join1 = pd.merge(df_user, df_user_package, on='user_id', how='inner')
usuario_plan = pd.merge(df_join1, df_package, on='package_code', how='inner')
usuario_plan = usuario_plan[['user_id', 'user_first_name', 'user_last_name', 'insurance_entity', 'package_code', 'package_name']]
print(tabulate(usuario_plan))

conteo_paquetes = usuario_plan['package_name'].value_counts()
print("Cantidad de usuarios por nombre de paquete:")
print(conteo_paquetes)
print(tabulate(conteo_paquetes.reset_index(), headers=["Nombre del Paquete", "Cantidad de Usuarios"]))


plt.figure(figsize=(10, 6))

conteo_paquetes.plot(kind='bar', color='green')
plt.title('Venta de Paquetes')
plt.xlabel('Nombre del Paquete')
plt.ylabel('Número de Usuarios')
plt.xticks(rotation=45) 

plt.savefig('paquetes.png', bbox_inches='tight')  
plt.close() 

df_left_join = pd.merge(df_user, df_user_package[['user_id', 'package_code']], on='user_id', how='left')
usuarios_no_plan = df_left_join[df_left_join['package_code'].isna()]
usuarios_no_plan = usuarios_no_plan[['user_id', 'user_first_name', 'user_last_name', 'insurance_entity', 'package_code']]
print(usuarios_no_plan)

df_right_join = pd.merge(df_employee, df_employee_appointment, on='employee_id', how='left')
empleados_sin_citas = df_right_join[df_right_join['appointment_code'].isna()]
print(empleados_sin_citas[['employee_id', 'employee_first_name', 'employee_last_name']])

df_user_appointment_join = pd.merge(df_user, df_user_appointment, on='user_id', how='outer')
usuarios_tipo_cita = pd.merge(df_user_appointment_join, df_appointment, left_on='appointment_code', right_on='appointment_code', how='outer')
print(usuarios_tipo_cita[['user_id', 'user_first_name', 'user_last_name', 'appointment_code', 'appointment_type']])


promedio_edades_eps = df_user.groupby('insurance_entity')['edad'].mean().round(1)
print("Promedio de edades por EPS:")
print(promedio_edades_eps)
plt.figure(figsize=(10, 6))

promedio_edades_eps.plot(kind='bar', color='purple')
plt.title('Promedio de edades por EPS')
plt.xlabel('EPS')
plt.ylabel('Años')
plt.xticks(rotation=45) 

plt.savefig('edad_eps.png', bbox_inches='tight')  
plt.close()

consulta_cantidad_eps = df_user.groupby('insurance_entity').size()
print(consulta_cantidad_eps)

cantidad_eps = pd.Series({'Coomeva': 6, 'EPS Sanitas': 10, 'EPS Sura': 18, 'Famisanar': 3, 'Nueva EPS': 3})
plt.figure(figsize=(10, 6))
cantidad_eps.plot(kind='pie', autopct='%1.1f%%', startangle=90)

plt.title('Cantidad de usuarios por EPS')
plt.ylabel('')  
plt.axis('equal')
plt.savefig('cantidad_eps.png', bbox_inches='tight')  
plt.close()
