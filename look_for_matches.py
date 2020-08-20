import csv

with open('roster_new.csv', 'r') as f1, open('old_facstaff.csv', 'r') as f2, open('out.csv', 'w', newline='') as out_file:
    data1 = list(csv.reader(f1))
    data2 = list(csv.reader(f2))
    writer = csv.writer(out_file, delimiter=',')

    for x in data1:
        for y in data2:
            if x[1] == y[1]:
                data2.remove(y)
            
    writer.writerows(data2)