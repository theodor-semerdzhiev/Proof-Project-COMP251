import numpy as np
import matplotlib.pyplot as plt
import pandas as pd


#loads cvs file and creates pair of x values m_data
data = pd.read_csv('../BinTree_out.csv')
n_data = np.arange(1,5000)
n_data = [x*10 for x in n_data]

#generate the pair of values for our theorical time complexity
n_vals = np.arange(1,100001)
logn_vals = (2.5)*n_vals*np.log2(n_vals)

#creates plot
fig, ax = plt.subplots()
ax.plot(n_vals, logn_vals, label='f(n) = 2.5∙n∙log(n)')
ax.scatter(n_data, data, s=0.5, c='orange',label='Node Deletion BST Runtime')
ax.set_xlabel('Input Size n', fontsize=12)
ax.set_ylabel('Runtime (ns)', fontsize=12)
plt.ylim(-1,2000000)
plt.xlim(-1,100000)
plt.legend(markerscale=5, loc='lower right')
plt.title('Time Complexity of node deletion of entire Binary Tree')
plt.ticklabel_format(useMathText=True, axis='y')
plt.tight_layout()
plt.show()