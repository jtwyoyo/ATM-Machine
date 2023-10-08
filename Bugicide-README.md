# Bugicide
เขียน introduction ให้หน่อย คิดไม่ออก

### First Test Case
```
public void calcCheckTransfer(double amount) {
		checkingBalance = checkingBalance - amount;
		savingBalance = savingBalance + amount;
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
        - C1 = amount is not null 
        - C2 = checkingBalance is not null 
        - C3 = savingBalance is not null 
      - Partition characteristics

        | Characteristics                  | b1   | b2    |
        |----------------------------------|------|-------|
        | C1 = amount is not null          | True | False |
        | C2 = checkingBalance is not null | True | False |
        | C3 = savingBalance is not null   | True | False |
      - Identify (possible) values
      
        | Characteristics                  | b1    | b2   |
        |----------------------------------|-------|------|
        | C1 = amount is not null          | 100.0 | null |
        | C2 = checkingBalance is not null | 100.0 | null |
        | C3 = savingBalance is not null   | 100.0 | null |
      - Combine partitions to define test requirements -ECC 
        - Assumption: choose Each choice 
        - Test requirements: number of tests = 2
          - (True,True,True), (False,False,False)
      - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.
      
        | Test                   | C1    | C2     | C3     | Expected result |
        |------------------------|-------|--------|--------|-----------------|
        | T1(True,True,True)     | 100.0 | 1000.0 | 2000.0 | 1               |
        | T2(False,False,False)  | null  | null   | null   | -1              |
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
        - C1 = Values of checkingBalance after the calculation with amount value. 
        - C2 = Values of savingBalance after the calculation with amount value. 
      - Partition characteristics
        
        | Characteristics                                                         | b1                                                             | b2                                      | b3                                                             |
        |-------------------------------------------------------------------------|----------------------------------------------------------------|-----------------------------------------|----------------------------------------------------------------|
        | C1 = Values of checkingBalance after the calculation with amount value  | checkingBalance value has decreased by the value of the amount | checkingBalance value is still the same | checkingBalance value has increased by the value of the amount |
        | C2 = Values of savingingBalance after the calculation with amount value | savingBalance value has decreased by the value of the amount   | savingBalance value is still the same   | savingBalance value has increased by the value of the amount   |
      - Identify (possible) values
      
        | Characteristics                                                        | b1      | b2     | b3     |
        |------------------------------------------------------------------------|---------|--------|--------|
        | C1 = Values of checkingBalance after the calculation with amount value | 1,100.0 | 1000.0 | 900.0  |
        | C2 = Values of saving Balance after the calculation with amount value  | 2,100.0 | 2000.0 | 1900.0 |
    - Combine partitions to define test requirements - ECC 
      - Assumption: choose Each choice 
      - Test requirements - number of tests = 3
        - (1,100.0, 1,900.0), (1000.0, 2000.0), (900, 2,100)
    - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.
    
      | Test                 | C1      | C2       | Expected Result |
      |----------------------|---------|----------|-----------------|
      | T1(1,100.0, 1,900.0) | 1,100.0 | 1900.0   | -1              |
      | T2(1000.0, 2000.0)   | 1,000.0 | 2000.0   | -1              |
      | T3(900, 2,100)       | 900.0   | 2,100.0  | 1               |

### Second Test Case
```
public void calcSavingTransfer(double amount) {
		savingBalance = savingBalance - amount;
		checkingBalance = checkingBalance + amount;
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
                - C1 = amount is not null
                - C2 = checkingBalance is not null
                - C3 = savingBalance is not null
            - Partition characteristics

              | Characteristics                  | b1   | b2    |
              |----------------------------------|------|-------|
              | C1 = amount is not null          | True | False |
              | C2 = checkingBalance is not null | True | False |
              | C3 = savingBalance is not null   | True | False |
            - Identify (possible) values

              | Characteristics                  | b1    | b2   |
              |----------------------------------|-------|------|
              | C1 = amount is not null          | 100.0 | null |
              | C2 = checkingBalance is not null | 100.0 | null |
              | C3 = savingBalance is not null   | 100.0 | null |
            - Combine partitions to define test requirements -ECC
                - Assumption: choose Each choice
                - Test requirements: number of tests = 2
                    - (True,True,True), (False,False,False)
            - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.

              | Test                   | C1    | C2     | C3     | Expected result |
              |------------------------|-------|--------|--------|-----------------|
              | T1(True,True,True)     | 100.0 | 1000.0 | 2000.0 | 1               |
              | T2(False,False,False)  | null  | null   | null   | -1              |
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
                - C1 = Values of checkingBalance after the calculation with amount value.
                - C2 = Values of savingBalance after the calculation with amount value.
            - Partition characteristics

              | Characteristics                                                         | b1                                                             | b2                                      | b3                                                             |
              |-------------------------------------------------------------------------|----------------------------------------------------------------|-----------------------------------------|----------------------------------------------------------------|
              | C1 = Values of checkingBalance after the calculation with amount value  | checkingBalance value has decreased by the value of the amount | checkingBalance value is still the same | checkingBalance value has increased by the value of the amount |
              | C2 = Values of savingingBalance after the calculation with amount value | savingBalance value has decreased by the value of the amount   | savingBalance value is still the same   | savingBalance value has increased by the value of the amount   |
            - Identify (possible) values

              | Characteristics                                                        | b1      | b2     | b3     |
              |------------------------------------------------------------------------|---------|--------|--------|
              | C1 = Values of checkingBalance after the calculation with amount value | 1,100.0 | 1000.0 | 900.0  |
              | C2 = Values of saving Balance after the calculation with amount value  | 2,100.0 | 2000.0 | 1900.0 |
        - Combine partitions to define test requirements - ECC
            - Assumption: choose Each choice
            - Test requirements - number of tests = 3
                - (1,100.0, 1,900.0), (1000.0, 2000.0), (900, 2,100)
        - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit.

          | Test                 | C1      | C2       | Expected Result |
          |----------------------|---------|----------|-----------------|
          | T1(1,100.0, 1,900.0) | 1,100.0 | 1900.0   | 1               |
          | T2(1000.0, 2000.0)   | 1,000.0 | 2000.0   | -1              |
          | T3(900, 2,100)       | 900.0   | 2,100.0  | -1              |

### Third Test Case
```
public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}
```
- Name of the test case: testcalcCheckingWithdraw
- Goal of the test case: To test the method calcCheckWithdraw is correctly calculate and update to the variables (checkingBalance)
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

              | Characteristics                                    |                   b1                   |                   b2                   |                   b3                   |
              |----------------------------------------------------|----------------------------------------|----------------------------------------|----------------------------------------|
              | C3 = Comparison between amount and checkingBalance | amount = 100.0, checkingBalance = 50.0 | amount = 100.0, checkingBalance = 100.0 | amount = 50.0, checkingBalance = 100.0 |
        - Combine partitions to define test requirements - Pair-Wise (**Mix the interface-based and the functionality-based characteristics’ blocks together**
            - Assumption: Making each pair blocks and choose each block to satisfy each pair)
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
        - Derive test values and expected values. These are the values that you have to use when you implement test cases in JUnit. (**Mix the interface-based and the functionality-based characteristics’ blocks together**)

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
### Fifth Test Case
### Sixth Test Case
### Seventh Test Case
### Eighth Test Case
### Ninth Test Case
### Tenth Test case
