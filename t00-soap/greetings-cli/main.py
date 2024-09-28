from zeep import Client

client = Client('https://apps.learnwebservices.com/services/hello?WSDL')
result = client.service.SayHello('John Doe from Python')

print(result)