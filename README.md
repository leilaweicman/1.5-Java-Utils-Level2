# 1.5-Java-Utils-Level2

## 📄 Description – Exercise Statement

This project contains the solution to the following Java exercise:

### Exercise 1
Execute **Exercise 3 from Level 1**, but parameterizing the methods with a configuration file.

The following values are read from `config.properties`:
- `directory`: the directory to list.
- `outputFile`: the name and path of the TXT file where the results will be saved.

#### ✅ What was implemented
- `DirectoryListerConfigurable`:
  - Loads configuration from `config.properties` using `Properties`.
  - Recursively lists the directory contents in alphabetical order.
  - For each entry, indicates whether it is a **directory (D)** or a **file (F)**.
  - Saves the result in a configurable TXT file instead of printing to the console.
- `config.properties` file:
  - Contains configurable values for `directory` and `outputFile`.

Example `config.properties`:
```sh
directory=src
outputFile=output.txt
```

---

## 💻 Technologies Used
- Java 17  
- IntelliJ IDEA  
- Git & GitHub  

---

## 📋 Requirements
- JDK 17 or higher installed  
- IntelliJ IDEA (or any Java-compatible IDE)  
- Git  

---

## 🛠️ Installation
Clone the repository and access the project folder:

```sh
git clone https://github.com/leilaweicman/1.5-Java-Utils-Level2.git
cd 1.5-Java-Utils-Level2
```

---

## ▶️ Execution

### Exercise 1

1. Make sure you have a valid config.properties in the project root, for example:
```sh
directory=src
outputFile=output.txt
```
2. Compile the program:
```sh
javac src/exercise1/DirectoryListerConfigurable.java
```
3. Run the program:
```sh
java -cp src exercise1.DirectoryListerConfigurable
```
3. The output will be saved in the file specified in `config.properties`.
   Example:
```sh
output.txt
```

---

## 🌐 Deployment
Not applicable (local practice project).


---

## 🤝 Contributions

1. Fork this repository.
2. Create a new branch:
```sh
git checkout -b feature/NewFeature
```
3. Commit your changes:
```sh
git commit -m "Add NewFeature"
```
4. Commit your changes:
```sh
git push origin feature/NewFeature
```
5. Open a Pull Request.
