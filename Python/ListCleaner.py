# Author: Nathan van der Velde
# Date Created: 2018-02-14
# Date Last Modified: 2018-02-14

with open('G:\\Marketing\\Email Marketing List\\BounceBackManager\\NewEmailList.csv', 'r') as in_file, open('G:\\Marketing\\Email Marketing List\\BounceBackManager\\NewCleanedEmailList.csv','w') as out_file:
    seen = set() #Set for fast O(1) amortized lookup
    for line in in_file:
        if line in seen: continue #Skip Duplicate

        seen.add(line)
        out_file.write(line)