import tabula
import pandas
import re

df = tabula.read_pdf('1.pdf', encoding='utf-8', pages='1-2')


temp = pandas.concat(df)
temp.to_csv('output.csv', encoding='utf-8', index=False)
