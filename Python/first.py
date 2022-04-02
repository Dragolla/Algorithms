"""
Problem:
Given an array A of N integers, return the smallest positive number that does not occur in A
Example:
Given A = [1,2,3,5,6} the code should return 4 as the answer
Given A = [-100, -200], the code should return 1 as the answer
"""
#test array
arr = [1,2,3,4,5,7,8,9]
def solution(A):
    d = {}
    # create a dict, with values of array as keys
    for i in A:
        if i not in d:
            d[i] = "placeholder"
    num = 1
    # checks if value of num already exists in dict
    for i in d:
        if num in d:
            num += 1
        else:
            print(num)
            break
solution(arr) #should print 6