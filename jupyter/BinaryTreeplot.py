import numpy as np
import matplotlib.pyplot as plt
import pandas as pd


#loads cvs file and creates pair of x values m_data
data = pd.read_csv('../BinTree_out.csv')
n_data = np.arange(0,9999)
n_data = [x*10 for x in n_data]

#generate the pair of values for our theorical time complexity
n_vals = np.arange(1,100001)
logn_vals = np.log2(n_vals)

#creates plot
fig, ax = plt.subplots()
ax.plot(n_vals, logn_vals, label='f(n) = log2(n)')

ax.set_xscale('log')
ax.scatter(n_data, data, s=0.5, c='orange',label='Node Deletion BST Runtime')
ax.set_xlabel('Input Size n', fontsize=12)
ax.set_ylabel('# of Operations', fontsize=12)
plt.ylim(-1,100)
plt.xlim(10,150000)

plt.legend(markerscale=5, loc='upper right')
plt.title('Time Complexity of node deletion in Binary Search Tree')
plt.ticklabel_format(useMathText=True, axis='y')
plt.tight_layout()
plt.show()