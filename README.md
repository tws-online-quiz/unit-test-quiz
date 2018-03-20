# Unit Test基础

## 练习描述

实现猜数字的游戏。游戏有四个格子，每个格子有一个0到9的数字，任意两个格子的数字都不一样。你有6次猜测的机会，如果猜对则获胜，否则失败。每次猜测时需依序输入4个数字，程序会根据猜测的情况给出xAxB的反馈，A前面的数字代表位置和数字都对的个数，B前面的数字代表数字对但是位置不对的个数。

例如：答案是1 2 3 4， 那么对于不同的输入，有如下的输出

 

**Example**：

> 答案是1 2 3 4， 那么对于不同的输入，有如下的输出
 
```
Input　　    Output             Instruction
1 5 6 7      1A0B                 1 correct
2 4 7 8      0A2B                 2 and 4 wrong position 
0 3 2 4      1A2B                 4 correct，2 and 3 wrong position
5 6 7 8      0A0B                 all wrong
4 3 2 1      0A4B                 4 numbers position wrong
1 2 3 4      4A0B                 win, all correct
1 1 2 3    Wrong Input，Input again
1 2        Wrong Input，Input again
```
 

答案在游戏开始时随机生成。输入只有6次机会，在每次猜测时，程序应给出当前猜测的结果，以及之前所有猜测的数字和结果以供玩家参考。输入界面为控制台（Console），以避免太多与问题无关的界面代码。输入时，用空格分隔数字。

## 环境要求
- Java 8

## 如何开始：

- 将题目clone到本地:
```
 git clone 仓库地址
```

- 初始化项目，在本地执行:

```
Mac/Linux: ./gradlew idea   
Whindows:  gradlew.bat idea  
```
- 运行测试，在本地执行：
```
Mac/Linux: ./gradlew clean test 
Whindows:  gradlew.bat clean test.
```

## 输出规范
- 设计和编写测试用例。
- 用小步骤进行单元测试重构。
- 使用Junit进行测试实现，Mockito可以在不同模块之间进行依赖隔离。
- 为单位测试和方法命名有意义的名称。
- 单元测试应涵盖所有核心业务逻辑。
- 代码通过小步骤提交并附上意义的评论。
- 请将你的代码提交到教练指定的仓库，其中需要包含：
    - 核心业务模块的单元测试
    - 单元测试用例
