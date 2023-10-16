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

              | Characteristics                       | b1    | b2    | b3     |
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

              | Characteristics                       | b1    | b2    | b3     |
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
          | T1(50.0, 100.0,  newcheckingBalance > amount)|    50.0  |   100.0  | newcheckingBalance > amount |       150.0     |
          | T2(0.0, 100.0,   newcheckingBalance > amount)|     0.0  |   100.0  | newcheckingBalance > amount |       100.0     |
          | T3(-50.0, 100.0, newcheckingBalance > amount)|   -50.0  |   100.0  | newcheckingBalance > amount |       50.0      |

### Fifth Test Case
```
public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}
```
- Name of the test case: testcalcSavingDeposit
- Goal of the test case: The goal of the test case in the provided code is to verify that the calcSavingDeposit method in the Account class correctly updates the checking account balance for various input scenarios.
    - **Interface-based characteristic**
        - Identify testable functions
            - calcSavingDeposit(double amount)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: double amount
            - Return Type: double
            - Return value: The current value of savingBalance
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = relation of amount to 0
                - C2 = relation of savingBalance to 0
            - Partition characteristics

              | Characteristics                       |       b1       |     b2     |     b3      |
              |---------------------------------------|----------------|------------|-------------|
              | C1 = relation of amount to 0          | Greater than 0 | Equal to 0 | Less than 0 |
              | C2 = relation of savingBalance to 0   | Greater than 0 | Equal to 0 | Less than 0 |
            - Identify (possible) values

              | Characteristics                       | b1    | b2    | b3     |
              |---------------------------------------|-------|-------|--------|
              | C1 = relation of amount to 0          | 50.0  |   0   | -50.0  |
              | C2 = relation of savingBalance to 0   | 100.0 |   0   | -100.0 |
    - **Functionality-based characteristic**
        - Identify testable functions
            - calcSavingDeposit(double amount)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: double amount
            - Return type: double
            - Return values: The current value of newSavingBalance
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C3 = Comparison between newSavingBalance and amount
            - Partition characteristics 

              | Characteristics                                     |            b1            |            b2            |            b3            |
              |---------------------------------------------------- |---------------------------|---------------------------|--------------------------|
              | C3 = Comparison between newSavingBalance and amount | newSavingBalance > amount | newSavingBalance = amount | newsavingBalance < amount |
            - Identify (possible) values

              | Characteristics                                    |                   b1                   | b2                                      |                   b3                   |
              |----------------------------------------------------|----------------------------------------|-----------------------------------------|----------------------------------------|
              | C3 = Comparison between savingBalance and amount   | savingBalance = 100.0, amount = 50.0   | savingBalance = 100.0, amount = 100.0 | savingBalance = 50.0, amount = 100.0 |
        - Combine partitions to define test requirements - BCC **(Mix the interface-based and the functionality-based characteristics’ blocks together)**
            - Assumption: BCC method
            - Test requirements: number of tests = 7
                - Feasibility Tests
                    - (50.0, 100.0,  newSavingBalance > amount)
                    - (0.0, 100.0,   newSavingBalance > amount)
                    - (-50.0, 100.0, newSavingBalance > amount)
                - Infeasibility Tests
                    - (50.0, 0.0,    newSavingBalance > amount)
                    - (50.0, -100.0, newSavingBalance > amount)
                    - (50.0, 100.0,  newSavingBalance = amount)
                    - (50.0, 100.0,  newSavingBalance < amount)
        - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit. **(Mix the interface-based and the functionality-based characteristics’ blocks together)**

          | Test                                         | C1       | C2       | C3                        | Expected Result |
          |----------------------------------------------|----------|----------|---------------------------|-----------------|
          | T1(50.0, 100.0,  newSavingBalance > amount)	 |    50.0  |   100.0  | newSavingBalance > amount |       150.0     |
          | T2(0.0, 100.0,   newSavingBalance > amount)  |     0.0  |   100.0  | newSavingBalance > amount |       100.0     |
          | T3(-50.0, 100.0, newSavingBalance > amount)  |   -50.0  |   100.0  | newSavingBalance > amount |       50.0      |
### Sixth Test Case
```
public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}
```
- Name of the test case: CalcSavingWithdrawTest
- Goal of the test case: To verify that the method calcSavingWithdraw is correctly calculated and updated to the savingBalance variables.
- Characteristics developed using Input Space Partitioning (ISP)
    - **Interface-based characteristic**
        - Identify testable functions
            - calcSavingWithdraw(double amount)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: double amount
            - Return Type: double
            - Return value: The current value of savingBalance
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = relation of amount to 0
                - C2 = relation of savingBalance to 0
                  
            - Partition characteristics
              | Characteristics                       |       b1       |     b2     |     b3      |
              |---------------------------------------|----------------|------------|-------------|
              | C1 = relation of amount to 0          | Greater than 0 | Equal to 0 | Less than 0 |
              | C2 = relation of savingBalance to 0   | Greater than 0 | Equal to 0 | Less than 0 |
              
            - Identify (possible) values
              | Characteristics                       | b1    | b2    | b2     |
              |---------------------------------------|-------|-------|--------|
              | C1 = relation of amount to 0          | 100.0 |   0   | -100.0 |
              | C2 = relation of savingBalance to 0   | 100.0 |   0   | -100.0 |
              
    - **Functionality-based characteristic**
        - Identify testable functions
            - calcSavingWithdraw(double amount)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: double amount
            - Return type: double
            - Return values: The current value of savingBalance
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C3 = Comparison between amount and savingBalance
                  
            - Partition characteristics 
              | Characteristics                                    |            b1            |            b2            |            b3            |
              |----------------------------------------------------|--------------------------|--------------------------|--------------------------|
              | C3 = Comparison between amount and savingBalance   | amount > savingBalance | amount = savingBalance | amount < savingBalance |
              
            - Identify (possible) values
              | Characteristics                                    |                   b1                   | b2                                      |                   b3                   |
              |----------------------------------------------------|----------------------------------------|-----------------------------------------|----------------------------------------|
              | C3 = Comparison between amount and savingBalance   | amount = 100.0, savingBalance = 50.0 | amount = 100.0, savingBalance = 100.0 | amount = 50.0, savingBalance = 100.0 |
              
        - Combine partitions to define test requirements - Pair-Wise **(Mix the interface-based and the functionality-based characteristics’ blocks together)**
            - Assumption: Create pairs of blocks and select each block to meet the requirements of each pair.
            - Test requirements: number of tests = 9
                - Feasibility Tests
                    - (100.0, 100.0, amount = savingBalance)
                    - (100.0, 0.0, amount > savingBalance)
                    - (0.0, 0.0, amount = savingBalance)
                    - (0.0, -100.0, amount > savingBalance)
                    - (0.0, 100.0, amount < savingBalance)
                    - (-100.0, -100.0, amount = savingBalance)
                    - (-100.0, 0.0, amount < savingBalance)
                - Infeasibility Tests
                    - (100.0, -100.0, amount < savingBalance)
                    - (-100.0, 100.0, amount > savingBalance)
        - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit. **(Mix the interface-based and the functionality-based characteristics’ blocks together)**

          | Test                                         | C1       | C2       | C3                       | Expected Result |
          |----------------------------------------------|----------|----------|--------------------------|-----------------|
          | T1(100.0, 100.0, amount = savingBalance)     |   100.0  |   100.0  | amount = savingBalance   |        0.0      |
          | T2(100.0, 0.0, amount > savingBalance)       |   100.0  |     0.0  | amount > savingBalance   |     -100.0      |
          | T3(0.0, 0.0, amount = savingBalance)         |     0.0  |     0.0  | amount = savingBalance   |        0.0      |
          | T4(0.0, -100.0, amount > savingBalance)      |     0.0  |  -100.0  | amount > savingBalance   |     -100.0      |
          | T5(0.0, 100.0, amount < savingBalance)       |     0.0  |   100.0  | amount < savingBalance   |      100.0      |
          | T6(-100.0, -100.0, amount = savingBalance)   |  -100.0  |  -100.0  | amount = savingBalance   |        0.0      |
          | T7(-100.0, 0.0, amount < savingBalance)      |  -100.0  |     0.0  | amount < savingBalance |      100.0      |

### Seventh Test Case
```
public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
	}
```
- Name of the test case: testConstructorA
- Goal of the test case: To test the constructor Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) such that it can create new account object and retain its data afterward.
- Characteristics developed using Input Space Partitioning (ISP)
    - **Interface-based characteristic**
        - Identify testable functions
            - Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: int customerNumber, int pinNumber, double checkingBalance, double savingBalance
            - Return Type: void
            - Return value: none
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = relation of customerNumber to 0
                - C2 = relation of pinNumber to 0
                - C3 = relation of savingBalance to 0
                - C4 = relation of checkingBalance to 0
            - Partition characteristics

              | Characteristics                       |       b1       |     b2     |     b3      |
              |---------------------------------------|----------------|------------|-------------|
              | C1 = relation of customerNumber to 0  | Greater than 0 | Equal to 0 | Less than 0 |
              | C2 = relation of pinNumber to 0       | Greater than 0 | Equal to 0 | Less than 0 |
              | C3 = relation of savingBalance to 0   | Greater than 0 | Equal to 0 | Less than 0 |
              | C4 = relation of checkingBalance to 0 | Greater than 0 | Equal to 0 | Less than 0 |
            - Identify (possible) values

              | Characteristics                       | b1    | b2    | b2    |
              |---------------------------------------|-------|-------|-------|
              | C1 = relation of customerNumer to 0   | 1234  |   0   | -1234 |
              | C2 = relation of pinNumber to 0       | 5678  |   0   | -5678 |
              | C3 = relation of savingBalance to 0   | 1000  |   0   | -1000 |
              | C4 = relation of checkingBalance to 0 | 1000  |   0   | -1000 |
	- Combine partitions to define test requirements - Multiple Based Choice Coverage
	            - Base Choices: (c1b1,c2b1,c3b1,c4b1), (c1b2,c2b2,c3b2,c4b2)
	            - Test requirements: number of tests =  10
	                - Feasibility Tests
	                    - new Account(1234,5678,1000,1000)
                            - new Account(0,0,0,0)
                            - new Account(1234,5678,1000,-1000)
                            - new Account(1234,5678,-1000,1000)
                            - new Account(1234,-5678,1000,1000)
                            - new Account(-1234,5678,1000,1000)
                            - new Account(0,0,0,-1000)
                            - new Account(0,0,-1000,0)
                            - new Account(0,-5678,0,0)
                            - new Account(-1234,0,0,0)
   	- Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.

          | Test                     | C1     | C2      | C3    | C4    | Expected      |
          |--------------------------|--------|---------|-------|-----------------------|
          | T1(1234,5678,1000,1000)  |  1234  |   5678  |  1000 | 1000  |  CREATED      |
          | T2(0,0,0,0)              |    0   |     0   |    0  |   0   |  CREATED      |
          | T3(1234,5678,1000,-1000) |  1234  |   5678  |  1000 | -1000 |  CREATED      |
          | T4(1234,5678,-1000,1000) |  1234  |   5678  | -1000 |  1000 |  CREATED      |
          | T5(1234,-5678,1000,1000) |  1234  |  -5678  |  1000 |  1000 |  CREATED      |
          | T6(-1234,5678,1000,1000) |  1234  |   5678  |  1000 |  1000 |  CREATED      |
          | T7(0,0,0,-1000)          |    0   |    0    |   0   | -1000 |  CREATED      |
   	  | T8(0,0,-1000,0)          |    0   |    0    | -1000 |   0   |  CREATED      |
          | T9(0,-5678,0,0)          |    0   |  -5678  |   0   |   0   |  CREATED      |
          | T10(-1234,0,0,0)         | -1234  |    0    |   0   |   0   |  CREATED      |
   	  
    - **Functionality-based characteristic**
        - Identify testable functions
            - Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: int customerNumber, int pinNumber, double checkingBalance, double savingBalance
            - Return type: void
            - Return values: none
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = the created object is an instance of Account class
                - C2 = the object retains 'customerNumber' value as provided
                - C3 = the object retains 'pinNumber' value as provided
                - C4 = the object retains 'savingBalance' value as provided
                - C5 = the object retains 'checkingBalance' value as provided
            - Partition characteristics 

              | Characteristics                                             |  b1  |  b2   |
              |-------------------------------------------------------------|------|-------|
              | C1 = the created object is an instance of Account class     | True | False |
              | C2 = the object retains 'customerNumber' value as provided  | True | False |
              | C3 = the object retains 'pinNumber' value as provided       | True | False |
              | C4 = the object retains 'savingBalance' value as provided   | True | False |
              | C5 = the object retains 'checkingBalance' value as provided | True | False |
            - Identify (possible) value **accountA = new account(1234, 5678, 1000, 1000) and accountB = new Object, will be used as pre-condition for testing**

              | Characteristics                                             |    b1    |    b2    |
              |-------------------------------------------------------------|----------|----------|
              | C1 = the created object is an instance of Account class     | accountA | accountB |
              | C2 = the object retains 'customerNumber' value as provided  |   1234   |     0    |
              | C3 = the object retains 'pinNumber' value as provided       |   5678   |     0    |
              | C4 = the object retains 'savingBalance' value as provided   |   1000   |     0    |
              | C5 = the object retains 'checkingBalance' value as provided |   1000   |     0    |
        - Combine partitions to define test requirements - Multiple Based Choice Coverage
            - Base Choices: (c1b1,c2b1,c3b1,c4b1,c5b1), (c1b1,c2b1,c3b1,c4b1,c5b2)
            - Test requirements: number of tests =  10
                - Feasibility Tests
                    - (accountA, 1234, 5678, 1000, 1000)
                - Infeasibility Tests
                    - **Every other cases**
        - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.

          | Test                               | C1         |   C2        | C3       | C4       | C5      |  Expected      |
          |------------------------------------|------------|-------------|----------|----------|---------|----------------|
          | T11(accountA,1234,5678,1000,1000)  |  accountA  |   1234      | 5678     | 1000     | 1000    |  TRUE          |
          
### Eighth Test Case
```
public Account(int customerNumber, int pinNumber) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
	}
```
- Name of the test case: testConstructorB
- Goal of the test case: To test the constructor Account(int customerNumber, int pinNumber) such that it can create new account object and retain its data afterward.
- Characteristics developed using Input Space Partitioning (ISP)
    - **Interface-based characteristic**
        - Identify testable functions
            - Account(int customerNumber, int pinNumber)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: int customerNumber, int pinNumber
            - Return Type: void
            - Return value: none
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = relation of customerNumber to 0
                - C2 = relation of pinNumber to 0
            - Partition characteristics

              | Characteristics                       |       b1       |     b2     |     b3      |
              |---------------------------------------|----------------|------------|-------------|
              | C1 = relation of customerNumber to 0  | Greater than 0 | Equal to 0 | Less than 0 |
              | C2 = relation of pinNumber to 0       | Greater than 0 | Equal to 0 | Less than 0 |
            - Identify (possible) values

              | Characteristics                       | b1    | b2    | b2    |
              |---------------------------------------|-------|-------|-------|
              | C1 = relation of customerNumer to 0   | 1234  |   0   | -1234 |
              | C2 = relation of pinNumber to 0       | 5678  |   0   | -5678 |
	- Combine partitions to define test requirements - Multiple Based Choice Coverage
	            - Base Choices: (c1b1,c2b1), (c1b2,c2b2)
	            - Test requirements: number of tests =  6
	                - Feasibility Tests
	                    - new Account(1234,5678)
                            - new Account(0,0)
                            - new Account(1234,-5678)
                            - new Account(-1234,5678)
                            - new Account(0,-5678)
                            - new Account(-1234,0)
   	- Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.

          | Test                     | C1     | C2      |  Expected      |
          |--------------------------|--------|---------|----------------|
          | T1(1234,5678)            |  1234  |   5678  |    CREATED     | 
          | T2(0,0)                  |    0   |     0   |    CREATED     |
          | T3(1234,-5678)           |  1234  |   5678  |    CREATED     |
          | T4(-1234,5678)           |  1234  |   5678  |    CREATED     |
          | T5(0,-5678)              |  1234  |  -5678  |    CREATED     |
          | T6(-1234,0)              |  1234  |   5678  |    CREATED     |
   	  
    - **Functionality-based characteristic**
        - Identify testable functions
            - Account(int customerNumber, int pinNumber)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: int customerNumber, int pinNumber
            - Return type: void
            - Return values: none
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = the created object is an instance of Account class
                - C2 = the object retains 'customerNumber' value as provided
                - C3 = the object retains 'pinNumber' value as provided
            - Partition characteristics 

              | Characteristics                                             |  b1  |  b2   |
              |-------------------------------------------------------------|------|-------|
              | C1 = the created object is an instance of Account class     | True | False |
              | C2 = the object retains 'customerNumber' value as provided  | True | False |
              | C3 = the object retains 'pinNumber' value as provided       | True | False |
            - Identify (possible) value **accountA = new account(1234, 5678) and accountB = new Object, will be used as pre-condition for testing**

              | Characteristics                                             |    b1    |    b2    |
              |-------------------------------------------------------------|----------|----------|
              | C1 = the created object is an instance of Account class     | accountA | accountB |
              | C2 = the object retains 'customerNumber' value as provided  |   1234   |     0    |
              | C3 = the object retains 'pinNumber' value as provided       |   5678   |     0    |
        - Combine partitions to define test requirements - Multiple Based Choice Coverage
            - Base Choices: (c1b1,c2b1,c3b1), (c1b1,c2b1,c3b2)
            - Test requirements: number of tests =  6
                - Feasibility Tests
                    - (accountA, 1234, 5678)
                - Infeasibility Tests
                    - **Every other cases**
        - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.

          | Test                               | C1         |   C2        | C3       |  Expected      |
          |------------------------------------|------------|-------------|----------|----------------|
          | T11(accountA,1234,5678,1000,1000)  |  accountA  |   1234      | 5678     |  TRUE          |
### Ninth Test Case
```
public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}
```
- Name of the test case: SetPinNumberTest
- Goal of the test case: To verify that the method setPinNumber is correctly updated to the pinNumber variables.
- Characteristics developed using Input Space Partitioning (ISP)
    - **Interface-based characteristic**
        - Identify testable functions
            - setPinNumber(int pinNumber)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: int pinNumber
            - Return Type: int
            - Return value: The current value of pinNumber
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C1 = relation of pinNumber to 0
                  
            - Partition characteristics
              | Characteristics                       |       b1       |     b2     |     b3      |
              |---------------------------------------|----------------|------------|-------------|
              | C1 = relation of pinNumber to 0       | Greater than 0 | Equal to 0 | Less than 0 |
              
            - Identify (possible) values
              | Characteristics                       | b1    | b2    | b2     |
              |---------------------------------------|-------|-------|--------|
              | C1 = relation of pinNumber to 0       | 1234  |   0   | -5678  |
              
    - **Functionality-based characteristic**
        - Identify testable functions
            - setPinNumber(int pinNumber)
        - Identify parameters, return types, return values, and exceptional behavior
            - Parameters: int pinNumber
            - Return type: int
            - Return values: The current value of pinNumber
            - Exceptional behavior: nothing
        - Model the input domain
            - Develop characteristics
                - C2 = Pin number after call setPinNumber method is equal to old Pin number
                  
            - Partition characteristics 
              | Characteristics                                                             |            b1            |            b2            |
              |-----------------------------------------------------------------------------|--------------------------|--------------------------|
              | C2 = Pin number after call setPinNumber method is equal to old Pin number   |           True           |           False          |
              
            - Identify (possible) values
              | Characteristics                                                             |                   b1                   | b2                                      |
              |-----------------------------------------------------------------------------|----------------------------------------|-----------------------------------------|
              | C2 = Pin number after call setPinNumber method is equal to old Pin number   | 1234                                   | 99999                                   |
              
        - Combine partitions to define test requirements - ACOC **(Mix the interface-based and the functionality-based characteristics’ blocks together)**
            - Assumption: Create pairs of blocks and select each block to meet the requirements of each pair.
            - Test requirements: number of tests = 6
                - Feasibility Tests
                    - (Greater than 0, True)
                    - (Equal to 0, True)
                    - (Less than 0, True)
          
                 - Infeasibility Tests
                   - (Greater than 0, False)
                   - (Equal to 0, False)
                   - (Less than 0, False)
                   
        - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit. **(Mix the interface-based and the functionality-based characteristics’ blocks together)**

          | Test                                         | C1       | C2       |Expected Result |
          |----------------------------------------------|----------|----------|-----------------|
          | T1(Greater than 0, True)                     |   1234   |   1234   |      True       |
          | T2(Equal to 0, True)                         |     0    |    0     |      True       |
          | T3(Less than 0, True)                        |  -5678   |  -5678   |      True       |

### Tenth Test case
