# GallerySample applies MVVM combined with [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
## Hello World!
**Hello** this is my simple **Gallery Sample** project as a applicant's challenging assignment for applying for the Android developer position at [
Fossil 
](https://fossil.com.vn/).


In this project I apply MVVM in combination with clean architecture and more...
## MVVM (Model–View–ViewModel)
MVVM is now one of the most loved patterns out there, as it has had plenty of time to mature. The web community adopted the pattern after the Microsoft team formalized it in 2005. It eventually made its way into every UI-based framework.
One key advantage of MVVM is that it offers the right amount of decoupling. Another good thing is that the learning curve is similar to the other patterns.

MVVM has three main components: Model, View, and ViewModel.
<div align="center">
    <img src="https://raw.githubusercontent.com/thachnn2/gallery_sample/main/docs/mvvm_diagram.png" width="500" alt="mvvm diagram" />
</div>

Unlike MVP and MVC, there’s a fourth component: The Binder. This is the mechanism that links the Views to the ViewModels.
The Binder is usually handled by the platform or a third party library, so the developer doesn’t have to write it. For Android, you have the DataBinding library at our disposal.

## Why MVVM with Clean Architecture?
MVVM separates our view (i.e. Activities and Fragments) from our business logic. MVVM is enough for small projects, but when our codebase becomes huge, our ViewModels start bloating. Separating responsibilities becomes hard.

MVVM with Clean Architecture is pretty good in such cases. It goes one step further in separating the responsibilities of our code base. It clearly abstracts the logic of the actions that can be performed in our app.

## Advantages of Using Clean Architecture

1. our code is even more easily testable than with plain MVVM. 
   
2. our code is further decoupled (the biggest advantage.)
   
3. The package structure is even easier to navigate.
   
4. The project is even easier to maintain.
   
5. our team can add new features even more quickly.

## Architecture
<div align="center">
<img src="https://raw.githubusercontent.com/thachnn2/gallery_sample/main/docs/project_structure.png" width="600" alt="project structure" />
</div>

