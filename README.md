# Modularity and Decoupling, The Right Way

Slides on [SpeakerDeck](https://goo.gl/fsmi85)

Creating and maintaining a Java codebase is not an easy task, especially with a codebase with thousands of tests. We often try to solve this problem with new libraries, frameworks and even new languages that can create a false sense of decoupling and modularity. 

But the answer is not in the libraries, nor in the frameworks. The answer is in the core of the Java language itself and it has been there since the early stages. 

In this talk, you will learn how to organize your codebase in such a way that your code is really decoupled and modularized, and so that you don't have to modify your tests when you decide to change some implementation details (like choosing a different HTTP library or a different database abstraction layer).

## Branches

We have 2 branches:
 
 * `start` branch: which is the original code with the traditional approach of doing things and then
 * `finish` branch: that contains the refactored code with the final implementation
 
## How to run

If you have JDK11 already installed and configured in your machine, you only have to run the maven wrapper command to build and test the application:

```bash
./mvnw package
``` 

If you don't have the JDK11 installed, you have to run the JDK wrapper to download and configure the JDK for you followed by the maven wrapper command:

```bash
./jdk-wrapper.sh ./mvnw package
```
