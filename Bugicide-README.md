# Bugicide
เขียน introduction ให้หน่อย คิดไม่ออก

### First Test Case
```
public void calcCheckTransfer(double amount) {
		checkingBalance = checkingBalance - amount;
		savingBalance = savingBalance + amount;
	}
```
- Prefix/Postfix Values 
  - Prefix values
```
    @BeforeEach
    public void setup(){
    checkingBalance = 1000.0;
    savingBalance = 2000.0;
    account = new Account(12345, 6789, checkingBalance, savingBalance);
    account2 = new Account(6789, 12345, checkingBalance, savingBalance);
    account3 = new Account(57485, 1478, -1000, -2000);
    account4 = new Account(45458, 9654, 0, 0);
    amount = 100.0;
    amount2 = -100.0;
    amount3 = 0.0;
    }
```
- Name of the test case: testCalcSavingTransfer
- Goal of the test case: To test the method calcCheckTransfer is correctly calculate and update to the variables (savingBalance and checkingBalance)
- Characteristics developed using Input Space Partitioning (ISP)
  - **Interface-based characteristic** 
    - Identify testable functions
      - calcCheckTransfer(double amount)
    - Identify parameters, return types, return values, and exceptional behavior 
      - Parameters: double 
      - Return type: nothing 
      - Return values: nothing 
      - Exceptional behavior: nothing
    - Model the input domain 
      - Develop characteristics 
        - C1 = relation of amount to 0
        - C2 = relation of checking Balance to 0
        - C3 = relation of saving Balance to 0 
      - Partition characteristics

        | Characteristics                        | b1          | b2         | b3              |
        |----------------------------------------|-------------|------------|-----------------|
        | C1 = relation of amount to 0           | Less than 0 | Equal to 0 | Greater than 0  |
        | C2 = relation of checking Balance to 0 | Less than 0 | Equal to 0 | Greater than 0  |
        | C3 = relation of saving Balance to 0   | Less than 0 | Equal to 0 | Greater than 0  |
      - Identify (possible) values

        | Characteristics                        | b1      | b2   | b3     |
        |----------------------------------------|---------|------|--------|
        | C1 = relation of amount to 0           | -100.0  | 0.0  | 100.0  |
        | C2 = relation of checking Balance to 0 | -1000.0 | 0.0  | 1000.0 |
        | C3 = relation of saving Balance to 0   | -2000.0 | 0.0  | 2000.0 |
      - Combine partitions to define test requirements -ECC 
        - Assumption: choose Each choice 
        - Test requirements: number of tests = 3 
          - T1(Less than 0,Less than 0, Less than 0),
          - T2(Equal to 0, Equal to 0, Equal to 0),
          - T3(Greater than 0, Greater than 0,Greater than 0)
      - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.
      
        | Test                                              | amount | Expected Result                                                         |
        |---------------------------------------------------|--------|-------------------------------------------------------------------------|
        | T1(Less than 0,Less than 0, Less than 0)          | -100.0 | True(amount = -100.0,checkingBalance = -1000.0,savingBalance = -2000.0) | 
        | T2(Equal to 0, Equal to 0, Equal to 0)            | 0.0    | True(amount = 0.0,checkingBalance = 0.0,savingBalance = 0.0)            |
        | T3(Greater than 0, Greater than 0,Greater than 0) | 100.0  | True(amount = 100.0,checkingBalance = 1000.0,savingBalance = 2000.0)    |
  - **Functionality-based characteristic** 
    - Identify testable functions
      - calcCheckTransfer(double amount)
    - Identify parameters, return types, return values, and exceptional behavior
      - Parameters: double
      - Return type: nothing
      - Return values: nothing
      - Exceptional behavior: nothing
    - Model the input domain
      - Develop characteristics 
        - C1 = Values of checkingBalance after call calcCheckTransfer method < old checkingBalance 
        - C2 = Values of savingBalance after call calcCheckTransfer method > old savingBalance.
      - Partition characteristics

        | Characteristics                                                                          | b1   | b2    |
        |------------------------------------------------------------------------------------------|------|-------|
        | C1 = Values of checkingBalance after call calcCheckTransfer method < old checkingBalance | True | False |
        | C2 = Values of savingBalance after call calcCheckTransfer method > old savingBalance     | True | False |
      - Identify (possible) values

        | Characteristics                                                                          | b1    | b2     |
        |------------------------------------------------------------------------------------------|-------|--------|
        | C1 = Values of checkingBalance after call calcCheckTransfer method < old checkingBalance | 100.0 | -100.0 |
        | C2 = Values of savingBalance after call calcCheckTransfer method > old savingBalance     | 100.0 | -100.0 |
    - Combine partitions to define test requirements - ECC 
      - Assumption: choose Each choice 
      - Test requirements - number of tests = 2
        - T1(True,True)
        - T2(False,False)
    - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.

      | Test             | C1     | Expected Result                                           |
      |------------------|--------|-----------------------------------------------------------|
      | T1(True,True)    | 100.0  | True(checkingBalance = 900.0, savingBalance = 2,100.0)    |
      | T2(False,False)  | -100.0 | False(checkingBalance = 1,100.0, savingBalance = 1,900.0) |

### Second Test Case
```
public void calcSavingTransfer(double amount) {
		savingBalance = savingBalance - amount;
		checkingBalance = checkingBalance + amount;
	}
```
- Prefix/Postfix Values
- Prefix values
```
  @BeforeEach
  public void setup(){
  checkingBalance = 1000.0;
  savingBalance = 2000.0;
  account = new Account(12345, 6789, checkingBalance, savingBalance);
  account2 = new Account(6789, 12345, checkingBalance, savingBalance);
  account3 = new Account(57485, 1478, -1000, -2000);
  account4 = new Account(45458, 9654, 0, 0);
  amount = 100.0;
  amount2 = -100.0;
  amount3 = 0.0;
  }
```
- Name of the test case: testCalcSavingTransfer
- Goal of the test case: To test the method calcCheckTransfer is correctly calculate and update to the variables (savingBalance and checkingBalance)
- Characteristics developed using Input Space Partitioning (ISP)
    - **Interface-based characteristic**
        - Identify testable functions
            - calcCheckTransfer(double amount)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: double
            - Return type: nothing
            - Return values: nothing
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = relation of amount to 0 
                - C2 = relation of checking Balance to 0 
                - C3 = relation of saving Balance to 0
      - Partition characteristics

        | Characteristics                        | b1          | b2         | b3              |
        |----------------------------------------|-------------|------------|-----------------|
        | C1 = relation of amount to 0           | Less than 0 | Equal to 0 | Greater than 0  |
        | C2 = relation of checking Balance to 0 | Less than 0 | Equal to 0 | Greater than 0  |
        | C3 = relation of saving Balance to 0   | Less than 0 | Equal to 0 | Greater than 0  |
      - Identify (possible) values
              
        | Characteristics                        | b1      | b2   | b3     |
        |----------------------------------------|---------|------|--------|
        | C1 = relation of amount to 0           | -100.0  | 0.0  | 100.0  |
        | C2 = relation of checking Balance to 0 | -1000.0 | 0.0  | 1000.0 |
        | C3 = relation of saving Balance to 0   | -2000.0 | 0.0  | 2000.0 |
      - Combine partitions to define test requirements -ECC
          - Assumption: choose Each choice
          - Test requirements: number of tests = 3
              - T1(Less than 0,Less than 0, Less than 0), 
              - T2(Equal to 0, Equal to 0, Equal to 0), 
              - T3(Greater than 0, Greater than 0,Greater than 0)
      - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.

        | Test                                              | amount | Expected Result                                                         |
        |---------------------------------------------------|--------|-------------------------------------------------------------------------|
        | T1(Less than 0,Less than 0, Less than 0)          | -100.0 | True(amount = -100.0,checkingBalance = -1000.0,savingBalance = -2000.0) |
        | T2(Equal to 0, Equal to 0, Equal to 0)            | 0.0    | True(amount = 0.0,checkingBalance = 0.0,savingBalance = 0.0)            |
        | T3(Greater than 0, Greater than 0,Greater than 0) | 100.0  | True(amount = 100.0,checkingBalance = 1000.0,savingBalance = 2000.0)    |
  - **Functionality-based characteristic**
      - Identify testable functions
          - calcCheckTransfer(double amount)
      - Identify parameters, return types, return values, and exceptional behavior
          - Parameters: double
          - Return type: nothing
          - Return values: nothing
          - Exceptional behavior: nothing
      - Model the input domain
          - Develop characteristics
              - C1 = Values of checkingBalance after call calcCheckTransfer method > old checkingBalance
              - C2 = Values of savingBalance after call calcCheckTransfer method < old savingBalance.
          - Partition characteristics

            | Characteristics                                                                          | b1   | b2    |
            |------------------------------------------------------------------------------------------|------|-------|
            | C1 = Values of checkingBalance after call calcCheckTransfer method > old checkingBalance | True | False |
            | C2 = Values of savingBalance after call calcCheckTransfer method < old savingBalance     | True | False |
          - Identify (possible) values

            | Characteristics                                                                          | b1    | b2     |
            |------------------------------------------------------------------------------------------|-------|--------|
            | C1 = Values of checkingBalance after call calcCheckTransfer method > old checkingBalance | 100.0 | -100.0 |
            | C2 = Values of savingBalance after call calcCheckTransfer method < old savingBalance     | 100.0 | -100.0 |
      - Combine partitions to define test requirements - ECC
          - Assumption: choose Each choice
          - Test requirements - number of tests = 2
              - T1(True,True)
              - T2(False,False)
      - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.

        | Test             | C1     | Expected Result                                          |
        |------------------|--------|----------------------------------------------------------|
        | T1(True,True)    | 100.0  | True(checkingBalance = 1,100.0, savingBalance = 1,900.0) |
        | T2(False,False)  | -100.0 | False(checkingBalance = 900.0, savingBalance = 2,100.0)  |


### Third Test Case
```
public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}
```
- Name of the test case: testcalcCheckingWithdraw
- Goal of the test case: To test the method calcCheckWithdraw is correctly calculated and updated to the variables (checkingBalance)
- Characteristics developed using Input Space Partitioning (ISP)
    - **Interface-based characteristic**
        - Identify testable functions
            - calcCheckingWithdraw(double amount)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: double amount
            - Return Type: double
            - Return value: The current value of checkingBalance
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = relation of amount to 0
                - C2 = relation of checkingBalance to 0
            - Partition characteristics

              | Characteristics                       |       b1       |     b2     |     b3      |
              |---------------------------------------|----------------|------------|-------------|
              | C1 = relation of amount to 0          | Greater than 0 | Equal to 0 | Less than 0 |
              | C2 = relation of checkingBalance to 0 | Greater than 0 | Equal to 0 | Less than 0 |
            - Identify (possible) values

              | Characteristics                       | b1    | b2    | b2     |
              |---------------------------------------|-------|-------|--------|
              | C1 = relation of amount to 0          | 100.0 |   0   | -100.0 |
              | C2 = relation of checkingBalance to 0 | 100.0 |   0   | -100.0 |
    - **Functionality-based characteristic**
        - Identify testable functions
            - calcCheckingWithdraw(double amount)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: double amount
            - Return type: double
            - Return values: The current value of checkingBalance
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C3 = Comparison between amount and checkingBalance
            - Partition characteristics 

              | Characteristics                                    |            b1            |            b2            |            b3            |
              |----------------------------------------------------|--------------------------|--------------------------|--------------------------|
              | C3 = Comparison between amount and checkingBalance | amount > checkingBalance | amount = checkingBalance | amount < checkingBalance |
            - Identify (possible) values

              | Characteristics                                    |                   b1                   | b2                                      |                   b3                   |
              |----------------------------------------------------|----------------------------------------|-----------------------------------------|----------------------------------------|
              | C3 = Comparison between amount and checkingBalance | amount = 100.0, checkingBalance = 50.0 | amount = 100.0, checkingBalance = 100.0 | amount = 50.0, checkingBalance = 100.0 |
        - Combine partitions to define test requirements - Pair-Wise **(Mix the interface-based and the functionality-based characteristics’ blocks together)**
            - Assumption: Make each pair of blocks and choose each block to satisfy each pair
            - Test requirements: number of tests = 9
                - Feasibility Tests
                    - (100.0, 100.0, amount = checkingBalance)
                    - (0.0, 0.0, amount = checkingBalance)
                    - (-100.0, -100.0, amount = checkingBalance)
                    - (100.0, 0.0, amount > checkingBalance)
                    - (0.0, -100.0, amount > checkingBalance)
                    - (0.0, 100.0, amount < checkingBalance)
                    - (-100.0, 0.0, amount < checkingBalance)
                - Infeasibility Tests
                    - (100.0, -100.0, amount < checkingBalance)
                    - (-100.0, 100.0, amount > checkingBalance)
        - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit. **(Mix the interface-based and the functionality-based characteristics’ blocks together)**

          | Test                                         | C1       | C2       | C3                       | Expected Result |
          |----------------------------------------------|----------|----------|--------------------------|-----------------|
          | T1(100.0, 100.0, amount = checkingBalance)   |   100.0  |   100.0  | amount = checkingBalance |       0.0       |
          | T2(0.0, 0.0, amount = checkingBalance)       |     0.0  |     0.0  | amount = checkingBalance |       0.0       |
          | T3(-100.0, -100.0, amount = checkingBalance) |  -100.0  |  -100.0  | amount = checkingBalance |       0.0       |
          | T4(100.0, 0.0, amount > checkingBalance)     |   100.0  |     0.0  | amount > checkingBalance |     -100.0      |
          | T5(0.0, -100.0, amount > checkingBalance)    |     0.0  |  -100.0  | amount > checkingBalance |     -100.0      |
          | T6(0.0, 100.0, amount < checkingBalance)     |     0.0  |   100.0  | amount < checkingBalance |      100.0      |
          | T7(-100.0, 0.0, amount < checkingBalance)    |  -100.0  |     0.0  | amount < checkingBalance |      100.0      |

### Fourth Test Case
```
public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}
```
- Name of the test case: testcalcCheckingDeposit
- Goal of the test case: The goal of the test case in the provided code is to verify that the calcCheckingDeposit method in the Account class correctly updates the checking account balance for various input scenarios.
    - **Interface-based characteristic**
        - Identify testable functions
            - calcCheckingWithdraw(double amount)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: double amount
            - Return Type: double
            - Return value: The current value of checkingBalance
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = relation of amount to 0
                - C2 = relation of checkingBalance to 0
            - Partition characteristics

              | Characteristics                       |       b1       |     b2     |     b3      |
              |---------------------------------------|----------------|------------|-------------|
              | C1 = relation of amount to 0          | Greater than 0 | Equal to 0 | Less than 0 |
              | C2 = relation of checkingBalance to 0 | Greater than 0 | Equal to 0 | Less than 0 |
            - Identify (possible) values

              | Characteristics                       | b1    | b2    | b2     |
              |---------------------------------------|-------|-------|--------|
              | C1 = relation of amount to 0          | 50.0  |   0   | -50.0  |
              | C2 = relation of checkingBalance to 0 | 100.0 |   0   | -100.0 |
    - **Functionality-based characteristic**
        - Identify testable functions
            - calcCheckingDeposit(double amount)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: double amount
            - Return type: double
            - Return values: The current value of newcheckingBalance
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C3 = Comparison between newcheckingBalance and amount
            - Partition characteristics 

              | Characteristics                                    |            b1            |            b2            |            b3            |
              |----------------------------------------------------|--------------------------|--------------------------|--------------------------|
              | C3 = Comparison between newcheckingBalance and amount | newcheckingBalance > amount | newcheckingBalance = amount | newcheckingBalance < amount |
            - Identify (possible) values

              | Characteristics                                    |                   b1                   | b2                                      |                   b3                   |
              |----------------------------------------------------|----------------------------------------|-----------------------------------------|----------------------------------------|
              | C3 = Comparison between checkingBalance and amount | checkingBalance = 100.0, amount = 50.0 | checkingBalance = 100.0, amount = 100.0 | checkingBalance = 50.0, amount = 100.0 |
        - Combine partitions to define test requirements - BCC **(Mix the interface-based and the functionality-based characteristics’ blocks together)**
            - Assumption: BCC method
            - Test requirements: number of tests = 7
                - Feasibility Tests
                    - (50.0, 100.0,  newcheckingBalance > amount)
                    - (0.0, 100.0,   newcheckingBalance > amount)
                    - (-50.0, 100.0, newcheckingBalance > amount)
                - Infeasibility Tests
                    - (50.0, 0.0,    newcheckingBalance > amount)
                    - (50.0, -100.0, newcheckingBalance > amount)
                    - (50.0, 100.0,  newcheckingBalance = amount)
                    - (50.0, 100.0,  newcheckingBalance < amount)
        - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit. **(Mix the interface-based and the functionality-based characteristics’ blocks together)**

          | Test                                         | C1       | C2       | C3                          | Expected Result |
          |----------------------------------------------|----------|----------|-----------------------------|-----------------|
          | T1(50.0, 100.0,  newcheckingBalance > amount)|   100.0  |   100.0  | newcheckingBalance > amount |       200.0     |
          | T2(0.0, 100.0,   newcheckingBalance > amount)|     0.0  |     0.0  | newcheckingBalance > amount |       0.0       |
          | T3(-50.0, 100.0, newcheckingBalance > amount)|   -50.0  |  -100.0  | newcheckingBalance > amount |       50.0      |

### Fifth Test Case
### Sixth Test Case
### Seventh Test Case
### Eighth Test Case
### Ninth Test Case
### Tenth Test case
