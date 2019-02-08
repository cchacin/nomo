# Refactoring to functional
 
- Package by feature (vs. by layer: https://github.com/EnterpriseQualityCoding/FizzBuzzEnterpriseEdition)
  - By looking at the structure you can already tell what the app is all about
  - Higher modularity
  - Easier code navigation
  - Higher level of abstraction
  - Separates both features and layers
  - More readable and maintainable structure
  - More cohesion
  - Much easier to scale
  - Less chance to accidentally modify unrelated classes or files
  - Much easier to add or remove application features
  - And much more reusable modules.
- Modularity and deletion
  - Scopes (public, package-private)
- Decoupling code using Java's Functional interfaces
- Dependency injection. Binding Functional interfaces to implementations (lambdas, method references, anonymous classes, etc)
- Testing without the need of a Mocking framework thanks to Java's Functional interfaces.
- Exercises
  - > Iterate over the lines of a file, take only the lines that contains the text "23",sort the result in natural order, and return the first line of that result.
    - `cat README.md | grep Functional | sort -r`


QUOTES:

- FP: spend less time worrying about state (Brian Gesiak)
- 
