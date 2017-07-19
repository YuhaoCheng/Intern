import  numpy as np
import  tensorflow as tf
"""""
list = np.array([1,2,3])
sess = tf.Session()
c = tf.constant(5.0)
a = tf.Variable([1,2,3,4,5,6,7,8])
init_op  = tf.global_variables_initializer()
sess.run(init_op)
b= tf.argmax(a,0)
print(sess.run(b))
"""
a = 0.1
b = 1.0-0.1
print(b)