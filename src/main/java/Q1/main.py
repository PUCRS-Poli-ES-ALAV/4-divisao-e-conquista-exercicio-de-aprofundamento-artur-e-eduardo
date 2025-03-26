import random
import time

def merge(left, right):
    global iterations
    result = []
    i = j = 0
    
    while i < len(left) and j < len(right):
        iterations += 1
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    
    result.extend(left[i:])
    result.extend(right[j:])
    return result

def merge_sort(arr):
    global iterations
    if len(arr) <= 1:
        return arr
    
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    
    return merge(left, right)

def run_test(size):
    global iterations
    arr = [random.randint(0, 1000000) for _ in range(size)]
    iterations = 0
    start_time = time.time()
    sorted_arr = merge_sort(arr)
    end_time = time.time()
    
    print(f"Tamanho: {size}")
    print(f"Iterações: {iterations}")
    print(f"Tempo: {end_time - start_time:.6f} segundos\n")

# Executando os testes
for size in [32, 2048, 1048576]:
    run_test(size)
