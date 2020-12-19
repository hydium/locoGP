import csv
from math import log

n = 11 # Number of generations

# Unprocessed Data as text file
f = open("Fibonacci.txt", "r") # Rename this depending on the specific search problem being tested
dat = f.readlines()[2:]

# Processed Data as csv file
# More human readable csv file
file = open("Fibonacci.csv", "w", newline = "") # Rename this depending on the specific search problem being tested
writer = csv.writer(file)

# Contains x, y values for scatter plot
file_2 = open("Fibonacci_2.csv", "w", newline = "") # Rename this depending on the specific search problem being tested
writer_2 = csv.writer(file_2)

def Average(lst): 
    return sum(lst) / len(lst)

gen_dat = [] # List of lists. Each internal list holds one generation
index_list = [] # Index of "Generation" in the text file. Used for processing

best_fit = 99999999
best_fit_prob = 0
discarded_count = 0

for i in range(len(dat)):
    if "Generation" in dat[i]:
        index_list.append(i)
    else:
        #print(dat[i][dat[i].index(":")+2 :])
        fitness = float(dat[i][dat[i].index(":")+2 :])
        if (fitness > 1):
            discarded_count += 1
        if (fitness < best_fit):
            best_fit = fitness
            best_fit_prob = dat[i][dat[i].index("_")+1 : dat[i].index(" ")]
        dat[i] = fitness

for i in range(len(index_list)-1):
    gen_dat.append(dat[index_list[i]+1 : index_list[i+1]])
gen_dat.append(dat[index_list[-1]+1 :])

header_row = []
writer_2.writerow(["Generation", "Fitness"])
max_len = 0
for i in range(n):
    if len(gen_dat[i]) > max_len:
        max_len = len(gen_dat[i])
    for j in range(len(gen_dat[i])):
        writer_2.writerow([i, gen_dat[i][j]])
    header_row.append(i)
writer.writerow(header_row)

rows = []
temp_row = []
total_number = 0
for i in range(n):
    temp_row.append(Average(gen_dat[i]))
    total_number += len(gen_dat[i])
writer.writerow(temp_row)

for i in range(max_len):
    row = []
    for j in range(n):
        temp = ""
        if i < len(gen_dat[j]):
            temp = gen_dat[j][i]
        row.append(temp)
    writer.writerow(row)

print("Best fitness is " + str(best_fit) + " achieved by problem test " + str(best_fit_prob))
print("% Discarded is " + str(discarded_count/total_number*100))