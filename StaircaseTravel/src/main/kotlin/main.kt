fun main(args: Array<String>) {
    println("Hello World!")
}

fun staircaseTraversal(height: Int, maxSteps: Int): Int {

    var noOfWays = 0
    if(height < 0) {
        return 0
    }
    else if(height == 0) {
        return 1
    }
    for(steps in 1..maxSteps) {
        if(steps > height) {
            continue
        }

        noOfWays+=staircaseTraversal(height - steps, maxSteps)
    }
    return noOfWays
}