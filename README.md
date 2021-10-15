# Knapsack problem solver
### Purpose of this project
This open source project is a coding excerise for Kotlin and dynamic programming (DP) skills. The solver algorithm is a personal implementation of the DP algorithm for the 0-1 knapsack problem explained in [Knapsack Problems]. 


### Request & response format 

Thw following JSON is a valid input example for the application. Note that all parameters are integers.
```sh
{"weights":[10,20,30],"values":[60,100,120],"capacity":50}
```
Thw following JSON is the response for the input example. `status` atribute can have two values: `ok`, when the instance is solved and `failed` when the input is invalid.
```sh
{"status":"ok","optimal_solution":[2,3],"optimal_value":220}
```

   [knapsack problems]: <https://link.springer.com/book/10.1007%2F978-3-540-24777-7>
