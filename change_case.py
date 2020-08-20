import csv
import pandas as pd

# df = pd.read_csv('roster_new.csv')
# df = df.sort_values('First Name')
# df.to_csv('out.csv', index=False)

with open('old_facstaff.csv', 'r') as f1, open('out.csv', 'w', newline='') as out_file:
    r1 = csv.reader(f1)
    writer = csv.writer(out_file, delimiter=',')
    writer.writerow(next(r1))
    st = list(r1)
    for row in st:
        temp = row[1]
        row[1] = temp.upper()
        writer.writerow(row)
