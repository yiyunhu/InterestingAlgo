# Given the maximum size of the cache and an array of 
# page requests, calculate the number of cache misses.
# A cache miss when a page is requested but is not 
# found in the cache.

# example1: inputNum = [1,2,1,3,1,2], size = 2  -> Output = 5
# example2: inputNum = [2,3,1,3,2,1,4,3,2], size = 2 -> Output = 8

def cacheMisses(inputNum, size):
    count = 0
    cache = []
    for i in range(len(inputNum)):
        curr_c = inputNum[i]
        if curr_c not in cache:
            if (len(cache) < size):
                cache.append(curr_c)
            else:
                cache.remove(cache[0])
                cache.append(curr_c)
            count += 1
        else:
            cache.remove(curr_c)
            cache.append(curr_c)

    return count


inputNum = [2,3,1,3,2,1,4,3,2]
size = 2
inputNum1 = [7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0]
size1 = 3
print(cacheMisses(inputNum1, size1))