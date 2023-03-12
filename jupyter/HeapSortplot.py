import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

#loads cvs file and creates pair of x values m_data
data = pd.read_csv('HeapSort_out.csv')
n_data = np.arange(1,9999)
n_data = [x*100 for x in n_data]

#generate the pair of values for our theorical time complexity
n_vals = np.arange(1,10**6)
n_logn_vals = 10*n_vals*np.log(n_vals)

#create plot
fig, ax = plt.subplots(figsize=(8,6))
ax.plot(n_vals, n_logn_vals, linewidth=2, label="f(n)=10∙n∙log(n)")
ax.scatter(n_data, data, marker='o', c='orange', s=0.4, label='Heapsort Runtime')
ax.legend(markerscale=5, loc='lower right')
plt.title('Time Complexity of HeapSort')
ax.set_xlabel('Input Size n', fontsize=12)
ax.set_ylabel('Runtime (ns)', fontsize=12)

plt.ticklabel_format(useMathText=True, axis='y')
plt.ticklabel_format(style='plain', axis='x')
plt.tight_layout()
plt.show()