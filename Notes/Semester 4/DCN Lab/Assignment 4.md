
<center>
  <h1> Assignment 4 </h1>

</center>
Name: Kshitij Chandrakar<br>
Batch: 5 <br>
SAP: 500124827

---

<center>
  <h2> Theory </h2>
</center>

---

### 1. IP Addressing Basics

#### IPv4 and IPv6 Addressing
- ##### IPv4 (Internet Protocol Version 4):
  - Uses a 32-bit addressing scheme
  - allows around 4.3 billion unique addresses
  - written in decimal format, separated by dots
      (For Ex: 192.168.1.1)
- ##### IPv6 (Internet Protocol Version 6):
  - Uses a 128-bit addressing scheme
  - written in hexadecimal format, separated by colons (For Ex: 1011:09pa:00a2:0000:0000:9fe3:9102:4332).

#### Public vs. Private IP Addresses
- ##### Public IP Addresses:
  - Routable on the internet and assigned by ISPs (For Ex 8.8.8.8).
- ##### Private IP Addresses:
  - Used within local networks and not routable on the internet. <br>
  Their Address Ranges are:
    - Class A: 10.0.0.0 – 10.255.255.255
    - Class B: 172.16.0.0 – 172.31.255.255
    - Class C: 192.168.0.0 – 192.168.255.255

#### Subnet Masks
- A subnet mask defines the network and host portions of an IP address.
- For Ex: 255.255.0.0 indicates that the first two octets represent the network portion, and the last two octet represents hosts.


### 2. Subnetting

#### CIDR Notation and Its Role in Subnetting:
- CIDR: Classless Inter-Domain Routing
- A method to allocate IP addresses efficiently by eliminating the rigid class-based addressing system.
- Expressed using a suffix (For Ex: 192.168.1.0/24 means 24 bits for the network, 8 bits for hosts).
- Subnetting allows networks to be divided into smaller subnetworks, improving security and reducing IP wastage.
- Example: Splitting 192.168.1.0/24 into four subnets:
  - 192.168.1.0/26
  - 192.168.1.64/26
  - 192.168.1.128/26
  - 192.168.1.192/26

### 3. Supernetting

#### Definition and Advantages:
- Supernetting: The process of combining multiple smaller networks into a larger one by modifying the subnet mask.
- Reduces the number of routing table entries, improving efficiency.
- Helps ISPs aggregate multiple customer networks.

#### Real-World Applications:
- Used in ISP route aggregation to reduce the number of advertised routes.
- Helps in enterprise network management by consolidating multiple subnets.
- Example: Combining four /26 networks (192.168.1.0/26, 192.168.1.64/26, 192.168.1.128/26, 192.168.1.192/26) into a single /24 network (192.168.1.0/24).

---

<center>
  <h2> Practical </h2>
</center>

---

### 1. Subnetting a Corporate Network
#### Departments:
1. HR: 50 Hosts
2. IT: 100 Hosts
3. Finance: 30 Hosts

#### Subnets Sizes
Subnets Are Sized by Powers of 2.
Therefore nearest power of 2 for each department.
Subnets are determined by the formula:

Subnet = 32 - Number of Bits
1. HR: 64 [ 6 Bits, /26 Subnet ]
2. IT: 128 [ 7 Bits, /25 Subnet ]
3. Finance: 32 [ 5 Bits, /27 Subnet ]

#### Subnet Assignment:
(Allocating Sequentially We Have)
1. IT  (/25)
  -  Network Address: 192.168.1.0/25
  -  Broadcast Address: 192.168.1.127
  -  Subnet Mask: 255.255.255.128
  -  Usable IPs: 192.168.1.1 – 192.168.1.126

2. HR  (/26)
  - Network Address: 192.168.1.128/26
  - Broadcast Address: 192.168.1.191
  - Subnet Mask: 255.255.255.192
  - Usable IPs: 192.168.1.129 – 192.168.1.190

3. Finance  (/27)
  - Network Address: 192.168.1.192/27
  - Broadcast Address: 192.168.1.223
  - Subnet Mask: 255.255.255.224
  - Usable IPs: 192.168.1.193 – 192.168.1.222
### 2. Subnetting an ISP Network

Supernetting combines multiple contiguous networks into a single network. This reduces the number of routing table entries, Thus improving efficiency.

#### Given Networks:

- 192.168.10.0/24
- 192.168.11.0/24
- 192.168.12.0/24
- 192.168.13.0/24

#### Finding Common Bits in the Network Address
Since the subnet is /24, the third octet changes and is relevant. Thus, we find common bits in the third octet.

##### Given Values in 8 Bits:
- 10 : 00001010
- 11 : 00001011
- 12 : 00001100
- 13 : 00001101

We can See here, that only the last 6 bits remain constant. thus, to include all 4 networks we need a /22 Mask. _(16 + 6 = 22) 16 for the first 2 octets, 6 for the 3rd one_

#### New Network addresses
Since the new Subnet mask is /22, The Network Address 192.168.10.0/22 would cover all the four networks.

#### Advantages
- For the router, it reduces the number of entries in the routing table. (from 4 /24 Entries to 1 /22)
- The lower entry count improves efficiency and simplifies the network Management for Larger Networks.

### 3. Subnetting a University Network
#### Departments:
1. Engineering: 2,000 hosts
2. Medical: 1,500 hosts
3. Management: 1,000 hosts
4. Library: 500 hosts
5. Admin: 300 hosts
#### Subnets Sizes
Subnets Are Sized by Powers of 2.
Therefore nearest power of 2 for each department.
Subnets are determined by the formula:

Number of Bits are the nearest larger power of 2.

Subnet = 32 - Number of Bits
1. Engineering: 2048 [11 Bits, /21 Subnet]
2. Medical: 2048 [11 Bits, /21 Subnet]
3. Management: 1024 [10 Bits, /22 Subnet]
4. Library: 512 [9 Bits, /23 Subnet]
5. Admin: 512 [9 Bits, /23 Subnet]

#### Subnet Assignment:
(Allocating Sequentially We Have)
1. Engineering (/21)

  - Network Address: 172.16.0.0/21
  - Broadcast Address: 172.16.7.255
  - Usable IPs: 172.16.0.1 – 172.16.7.254
  - Subnet Mask: 255.255.248.0

2. Medical (/21)

  -  Network Address: 172.16.8.0/21
  -  Broadcast Address: 172.16.15.255
  -  Usable IPs: 172.16.8.1 – 172.16.15.254
  -  Subnet Mask: 255.255.248.0

3. Management (/22)

  -  Network Address: 172.16.16.0/22
  -  Broadcast Address: 172.16.19.255
  -  Usable IPs: 172.16.16.1 – 172.16.19.254
  -  Subnet Mask: 255.255.252.0

4. Library (/23)

  -  Network Address: 172.16.20.0/23
  -  Broadcast Address: 172.16.21.255
  -  Usable IPs: 172.16.20.1 – 172.16.21.254
  -  Subnet Mask: 255.255.254.0

5. Admin (/23)

  -  Network Address: 172.16.22.0/23
  -  Broadcast Address: 172.16.23.255
  -  Usable IPs: 172.16.22.1 – 172.16.23.254
  -  Subnet Mask: 255.255.254.0
