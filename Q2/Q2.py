file = open("D://Programming//MetaHackerCup2023//Q2//cheeseburger_corollary_2_input.txt", "r")

def calculate():
    line = file.readline().split()
    A, B, cost = int(line[0]), int(line[1]), int(line[2])

    if A <= B/2:
        k = cost/A
        return str(int(k))
    elif B <= A/2 or B == A:
        k = (cost/B) * 2 -1
        return str(int(k))
    else:
        k = 0
        while cost > 0:
            if cost < A and cost < B:
                return str(int(k))
            r = (cost % B)
            k += (cost/B)*2 - 1
            cost = r
            if cost > 0:
                k += cost/A
                cost = cost/A
        return (str(int(k)))


test_cases = int(file.readline())
for i in range(test_cases):
    print("Case #" + str(i+1) + ": " + calculate())