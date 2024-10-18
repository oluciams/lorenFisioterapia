import pandas as pd
import openpyxl
from tabulate import tabulate

df = pd.read_excel("db_fisioterapia.xlsx", sheet_name=None)

df_hoja1 = df["Hoja1"]  #DataFrame de la hoja "Hoja1"
df_hoja2 = df["Hoja2"]  #DataFrame de la hoja "Hoja2"
df_hoja3 = df["Hoja3"]  #DataFrame de la hoja "Hoja3"
df_hoja4 = df["Hoja4"]  #DataFrame de la hoja "Hoja4"

#consultar los usuarios con tipo de identificación CC
consulta1 = df_hoja1.query('user_type_id == "CC"')
print(consulta1)

#consultar los usuarios cuyas entidad no sea particular y su primer nombre sea Bradley
consulta2 = df_hoja1.query('insurance_entity != "Particular" & user_first_name == "Bradley"')
print(consulta2)

#agrupar y mostrar tamaño de identificación de empleados
consulta3 = df_hoja2.groupby("employee_id").size()
print(consulta3)

#agrupar y mostrar el máximo de los datos id empleado y tipo id empleado
consulta4 = df_hoja2.groupby(["employee_id", "employee_type_id"]).agg("max")
print(consulta4)

#relacionar 2 columnas de tablas diferentes y mostrar los id de ambas
consulta5 = pd.merge(df_hoja1, df_hoja2, left_on= "user_id", right_on="employee_id", how="outer")
idconsulta5 = consulta5[['user_id','employee_id']]
print(idconsulta5)

#obtener todos los registros de user_id y las coincidencias de employee_id.
consulta6 = pd.merge(df_hoja1, df_hoja2, left_on= "user_id", right_on="employee_id", how="left")
idconsulta6 = consulta6[['user_id','employee_id']]
print(idconsulta6)

#obtener todos los registros de employee_id y las coincidencias de user_id.
consulta7 = pd.merge(df_hoja1, df_hoja2, left_on= "user_id", right_on="employee_id", how="right")
idconsulta7 = consulta7[['user_id','employee_id']]
print(idconsulta7)
