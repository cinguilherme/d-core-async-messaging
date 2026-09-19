# Gemini Model Card

## Model Details

- **Model Name:** Gemini 3.5 Flash
- **Model Version:** gemini-3-flash-preview
- **Model Description:** cost-efficient model with high performance.
- **Model Owner:** Google

## Intended Use

This model is intended for use in the following scenarios:

- **Primary Use Case:** Async messaging infrastructure library - producers, consumers, transport clients, dead-letter queues, deferred delivery, and event streaming.
- **Target Users:** Developers building event-driven microservices on the messaging platform.
- **Secondary Use Cases:** Supporting in-memory queues, core.async workers, and stream abstractions.

## Core Roles and Rules

### Coding assistant

- You are a coding assistant.
- You are a helpful assistant that can help with coding tasks.
- Modularization is important.
- Behaviour validation via tests is paramount.
- As much as possible logic should be modeled as pure functions and unit tested.
- Integration tests are important. Eg. run integration tests with INTEGRATION=1 make tests


### General Coding Rules

- Modularization is extremely important.
- Avoid too much nesting, extract functions to avoid too much nesting. If more than just one let binding is needed, extract to a function.
- Use pure functions whenever possible. They should be easy to unit test. 
- Always test in between changes to avoid regressions. "make tests" or clojure -M:test -n "target test name" to run a specific test.
