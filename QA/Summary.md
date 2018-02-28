# QA

## Summary
This test is designed for people with some experience in an automated testing role. While a focus is provided on UI testing through web driver there is focus on scala and java testing.
***

## Skills   
Technical Skills:
 * Selenium Web Driver
 * Scala Test (preferred)
 * JUnit
 * Boundary Testing
 
 Soft Skills: 
 * Three Amigos
 * Scope of change analysis
 * Technical Risk assessment
 * Bug Report

## Stages of Testing

### External Test
_This part of the test is sent to potential candidates_

This test includes downloading and using an already established piece of software created for the purpose of the test.
Once its been downloaded the participate will make several changes based on provided user stories. These will be uploaded one story at the time, with commits following a specified pattern for the commit message.

The guidance is included alongside the project framework. 

### Internal Test
_This part of the test is administered as part of an interview_

This part of the test will include the same restrictions as the first. This part of the test contains two parts, one is an extension of the previous part (in order to confirm that people did complete the initial section) and a subsequent task to check how they handle a complete task from inception to completion.


After providing the candidate with a printed copy of the external test the following tasks are taken under the same guidance and steps as those of the external test.
```
Task 4:
    GIVEN I am QA
    AND I have performance and test result reports
    WHEN asked to provide a summary of results
    THEN I can vocalise the results as a summary in both a technical and non technical capacity

Task 5:
    GIVEN I am a QA
    AND I am aware of the avaliable URIs within an application
    WHEN asked to provide a risk assessment for possible misuse of these URIs
    THEN I am able to vocalise the possible risks based on the testing completed so far

Task 6:
    GIVEN I am provided with a typical user
    AND I have been told about testing previously conducted on this application
    WHEN asked to review and consider testing options 
    THEN I am able to explain my thinking and provide alternatives where traditional problems occur

Task 7:
    On the test triangle, what percentage of your time would you expect or hope to spend with each type of testing?
```

For Task 6, you will need the following information:
```
Application:
        Details
Purpose:
        To pull information from a database held on another network and provide it to applications
Application Behaviour:
        Applications make requests to the Details app to request a users details based on a 10 digit code (e.g. http://local.details/get/012xx9874g)
        Details makes a remote method call to a database handler that queries a SQL database to gather the user details
        if successful:
            the details are returned to the Details app as a java object
            The java object is then returned as a collection of details within the header of the response
        if non-successful due to timeout:
            terminates the connection with the database handler
            Details throws an exception returning a general error page
        if non-succesful due to invalid sql:
            terminates the connection to the database handler
            Details throws an exception detailing the exception in the log but returning a general error page to the user
Current Testing:
        Junit testing to ensure that the xml returned from the downstream databases can be read into objects and sent via mocked remote method invocation to the application
        Performance testing to ensure that given X amount of requests the application doesn't slow down Details ability to receive connections (no downstream connections made)
        Acceptance tests using stubs and mocked behaviour to check that if X amount of apps request the same details at the same time the behaviour is non blocking.
```