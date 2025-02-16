
def Stuffing(inp = "0111111011011111011111010", flag = "011111"):
    flagReplace = "0111101"
    flen = len(flag)
    print("Input is:", inp)
    print("Flag is:", flag)
    print("Replacement Flag is:", flagReplace)
    for i in range(len(inp)):
        if inp[i:i+flen] == flag:
            inp = inp[:i] + flagReplace + inp[i + flen:]
    print("Bit Stuffed Output is:",inp)
    print("Output with flags is: ", flag, inp, flag, sep="")
    return flag + inp + flag

def Destuff(inp = "0111110111101101101111010111101010011111", flag = "011111"):
    flagReplace = "0111101"
    flag, flagReplace = flagReplace, flag
    flen = len(flag)
    print("Input is:", inp)
    print("Flag is:", flag)
    print("Replacement Flag is:", flagReplace)
    for i in range(len(inp)):
        if inp[i:i+flen] == flag:
            inp = inp[:i] + flagReplace + inp[i + flen:]
    print("Bit destuff Output is:", inp)
    print("Bit destuff Output Without flags is:", inp[flen-1: -(flen-1)])


def Stuffing(inp = "110111111011111010"):
    stuffed = ""
    c = 0
    print("Input is:", inp)
    for bit in inp:
        if bit == "1":
            c += 1
        else:
            c = 0

        stuffed += bit

        if c == 5:
            stuffed += "0"
            c = 0
    print("Bit Stuffed Output is:", stuffed)
    return stuffed

def Destuff(inp = ""):
    print("Stuffed Input is", inp)
    destuff = ""
    c = 0
    i = 0

    while i < len(inp):
        destuff += inp[i]

        if inp[i] == "1":
            c += 1
        else:
            c = 0

        if c == 5:
            i += 1
            c = 0

        i += 1

    print("Bit Destuffed Output is:", destuff)
    return destuff

def main():
    inp = input("Enter Input (Blank for default): ")
    if inp != "":
        print("-------------In-------------")
        out = Stuffing(inp=inp)
        print("-------------Out-------------")
        Destuff(inp=out)
    else:
        print("Using Defaults")
        print("-------------In-------------")
        out = Stuffing()
        print("-------------Out-------------")
        Destuff(inp=out)
    pass
if __name__ == '__main__':
    main()
