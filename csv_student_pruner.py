import csv

with open('users.csv', 'r') as in_file, open('out.csv', 'w', newline='') as out_file:
    reader = csv.reader(in_file, skipinitialspace=True)
    writer = csv.writer(out_file, delimiter=',')

    writer.writerow(next(reader))

    for row in reader:
        # if row[7] == 'Default Spark with Premium Features for Higher-Ed - 2 GB configuration':
        if row[7] == 'Default All Apps plan - 1 TB configuration':
            writer.writerow(row)
