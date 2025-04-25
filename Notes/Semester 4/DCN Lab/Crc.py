def xor(a, b):
    result = []
    for i in range(1, len(b)):
        if a[i] == b[i]:
            result.append('0')
        else:
            result.append('1')
    return ''.join(result)

def div(divd, divs):
    c = len(divs)
    temp = divd[0 : c]

    while c< len(divd):
        print(temp, end = " ")
        if temp[0] == '1':
            temp = xor(divs, temp) + divd[c]
            print("a")
        else:
            temp = xor('0' * c, temp) + divd[c]
            print("b")
        c += 1

    if temp[0] == '1':
        temp = xor(divs, temp)
    else:
        temp = xor('0' * c, temp)
    print(temp)
    return temp

def encoding(data, poly):

    padded_data = data + '0' * (len(poly) - 1)
    remainder = div(padded_data, poly)
    trans_data = data + remainder

    print("Initial Data is: " + data)
    print("CRC is: " + remainder)
    print("Encoded Data is: " + trans_data)
    return (data,remainder)

data = "100100"
poly = "1011"
encoding(data, poly)
