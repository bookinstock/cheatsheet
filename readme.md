# cheatsheet

## scala

- It’s a high-level language
- It’s statically typed
- Its syntax is concise but still readable — we call it expressive
- It supports the object-oriented programming (OOP) paradigm
- It supports the functional programming (FP) paradigm
- It has a sophisticated type inference system
- Scala code results in .class files that run on the Java Virtual Machine (JVM)
- It’s easy to use Java libraries in Scala




### future

- You construct futures to run tasks off of the main thread
- Futures are intended for one-shot, potentially long-running concurrent tasks that eventually return a value
- A future starts running as soon as you construct it
- A benefit of futures over threads is that they come with a variety of callback methods that simplify the process of working with concurrent threads, including the handling of exceptions and thread management
- Handle the result of a future with methods like onComplete, or combinator methods like map, flatMap, filter, andThen, etc.
- The value in a Future is always an instance of one of the Try types: Success or Failure
- If you’re using multiple futures to yield a single result, you’ll often want to combine them in a for-expression
