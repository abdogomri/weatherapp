# weatherapp

this is the application Sequence diagram :

first of all the user needs to add cities to his watch list so he can check the weather : 

![gleek-TU6A-3-nadNXOthzglUaug](https://user-images.githubusercontent.com/26137154/222259425-3f20264c-03b3-4db4-86e1-0bed4aca78cf.png)

after selecting many cities , they are being added the the database so the user can find them later (persistant data) : 

![gleek-TU6A-3-nadNXOthzglUaug (1)](https://user-images.githubusercontent.com/26137154/222261989-ff0a3286-fe60-4e26-a28d-f4c91040cd77.png)

after creating a list of prefered cities, the user can check each city's weather, bellow is the sequence diagram in the case of (network connection available) : 

![gleek-TU6A-3-nadNXOthzglUaug (2)](https://user-images.githubusercontent.com/26137154/222269834-71c82184-0f67-431a-b4aa-48549d3556d7.png)

the same process would be executed when the user makes a "Pull to refresh" on the weather info fragment, see the diagram bellow : 

![gleek-TU6A-3-nadNXOthzglUaug (3)](https://user-images.githubusercontent.com/26137154/222271082-f101f93b-d135-4d67-9ca6-c0562b4d9e3d.png)

in case of the offline useCase see the diagram bellow : 

![gleek-TU6A-3-nadNXOthzglUaug (4)](https://user-images.githubusercontent.com/26137154/222272968-4861ace9-669d-43a7-9d65-eba4dedae40a.png)


As we can see in the sequence diagrams, the business logic is in the Default repository , it's where we define how data is retrieved and how it's stored in a convenient way , when the user has no internet we can retrieve data from the database , and when we have internet connection we can update the local data , we use the single source of truth principle, by always retrieving the updated data from local data source, on the application we are using interfaces as a method of abstraction , and we use Hilt as a dependency injection methode to provide the implementation of interfaces , this method is the best for our application extensibility and maintability , and makes it easy for testing .

connection between datasources and view models is done using Coroutines for asynchronous programming (so we don't block our main thread), and we use Flows and StateFlows for reactive programming principle, databinding to access data from the view ( we access uiStates ), Databinding supports reactive programming (State flow in our case) which means a change in UiState -> change in the view .






