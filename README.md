# test-sebrae

For this scenario I tried to divide in MVC model, but I preferred use:
- Controller to keep layer that receive the requests
- Model to keep the main object that is passed between controller, service and database
- Repository to keep the interface that connects with external resources or database
- Service to keep the layer between external resources as CEP API and test business rules

- To the next improvement would be return DTO instead of Conta in Controller Responses to send only data that users must seen