from pprint import pprint
from columnar import columnar
import numpy as np
# %% code cell
y = 20
# %% code cell
def nonNeg(j):
    for i in range(len(j)):
        if j[i] >= 0:
            return j[i:]
    pass
# %% code cell
attendance = []
for i in range(y):
        X = [ (j-i)/j for j in range(1,y+1) ]
        attendance.append(X)

# %% code cell
attendance=  np.transpose(attendance).tolist()

# %% code cell
for i in range(y):
    attendance[i].reverse()

# %% code cell

headers = [str(i) for i in range(1,len(attendance))]
columns = columnar(attendance, headers)



# %% code cell
for i in attendance:
    temp = nonNeg(i)
    print(len(temp))
    temp.reverse()
    for j in temp:
        print(str(j)[:5], end = " ")
    print()
