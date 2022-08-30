# Ultraviolet Coding Compendium


### **Public vs Private:**
Everywhere that this guide uses `public` or `private`, they can be swaped
but your code won't work the same. Use `public` only for classes, most functions, and some constants.
Use `private` if it is effecting something that should only be used in the file that it is in.

### **Constants:**

What if I have a number that never changes? What you need is a constant. As the name implies, constants stay constant.
The syntax for constants is:
~~~java
public static final int CONSTANT = 1;
~~~
Replace `public` with `private` if you only use the constant in one file, and replace `int` with whatever
type of value is needed. Constants should be
in all CAPS, words separated_by_underscores.

Constants can either be defined in the file that they are used in (ex. Motor ID's), or they 
can be defined in a `Constants.java` file if they are used in multiple places,
or they just don't belong in any one place.

One of my favorite lines of code that I have ever written was a constant. It went:
~~~java
public static final String Gerald = "Gerald";
~~~



### **Functions:**

Quick! I need an input and an output. What I need is a function. Functions are defined by writing this:
~~~java
public double halveANumber(int input) {
  return input / 2;
}
~~~

Most functions are eiher public or private, depending on if it is supposed to be used outside of that file. All functions have an output type.
In the example above, the output type was `double` but I could have put `int`, `String`, any other type, or  `void` meaning no output.
Functions can have inputs but they don't have to. The inputs go between the parenthesis and you can have as many as you want with different types.
This can look like this:
~~~java
public void lotsOfInputs(int inputOne, double inputTwo, String inputThree) {
  System.out.println("Foo");
}
~~~
Functions should have a name in camelCase likeThis with the first letter lowercase and the first letter of each word uppercase.
Everything that a function does goes inside the {brackets} and if it doesn't say `void` you have to have a `return` where you have the output.


### **Constructors:**

Constructors are a special type of function that runs automatically when the program starts (not really but for simplicity, yes).
An example of a constructor is this:
~~~java
public class Spinner {

  // v This is the constructor
  public Spinner() {
    // Give variables values here.
  }
}
~~~

Constructors are very powerful so be sure to ask about them during training!

### **Final Variables:**

Final variables look like this:

~~~java
private final TalonSRX motor;

public Constructor() {
  motor = new TalonSRX();
}
~~~

Final variables are used for objects that will never change while the object is running (Like motors never change ID's, neither do XboxControllers).
The clean and proper way to write these variables is to define that they exist at the top of the file using `public final double variableName`.
And given a value in the constructor. These variables should be camelCase like functions (no parenthesis though).

### **Classes:**
Classes look like this:
~~~java
public class ClassName {

}
~~~

They should be `public` and have a CamelCase name starting with an uppercase letter. The name of the class MUST be the same as the name of the file (minus the .java).
In terms of what a class is / what it does, ask. Please, just ask.


### **VSCode Tips and Tricks:**
VSCode (It might be called 2022 WPILib VSCode for you) will take a lot of the typing and frustration out of coding.
Here is a list of my favorite tips:
* Tab to autocomplete if it shows up. If there is a list of things, use arrow keys to scroll through and hit tab when you've got the right one.
* Hover over red underlines, click quick fix, and see if it has something that looks right (Ususally import).
* `Control` + `/` to comment out a line of code (ask if you don't know what this means).


### **Comments and Printing:**

Sometimes, you just want to leave a note for yourself. This is a great spot for a comment. Comments have no effect on the code, it just makes it easier to read.
Here are some examples of comments:
~~~java
// Single line comment

/*
 * BIG
 *
 * COMMENT
 */
~~~

Other times, you just want to know what is going on with a variable or just tell yourself hello. You can do this by using a print statement like this:
~~~java
System.out.prinln("Hello world");
~~~
