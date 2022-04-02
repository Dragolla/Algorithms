"""
Problem:
Given an array A of N integers, return the smallest positive number that does not occur in A
Example:
Given A = [1,2,3,5,6} the code should return 4 as the answer
Given A = [-100, -200], the code should return 1 as the answer
"""
arr = [1,2,3,4,5,7,8,9] #test array
def solution(A):
    d = {}
    for i in A:
        if i not in d:
            d[i] = "placeholder"
    start = 1
    for i in d:
        if start in d:
            start += 1
        else:
            print(start) 
            break
solution(arr) #should print 6