import sqlite3
import pandas as pd

# Conectar a la base de datos
bd = sqlite3.connect("base_datos_fisioterapia.sql")
df = pd.read_sql("select * from package", bd)

print(df)