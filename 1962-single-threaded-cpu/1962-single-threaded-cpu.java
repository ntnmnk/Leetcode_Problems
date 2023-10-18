class Solution {
    public int[] getOrder(int[][] tasks) {
              // Create a comparator for tasks, first by processing time, then by index
        Comparator<Task> processingTimeThenIndex = Comparator
            .comparingInt(Task::getProcessingTime)
            .thenComparingInt(Task::getIndex);
        
        // Use two priority queues for task management
        // allTasks contains all tasks and is sorted by enqueue time, processing time, and index
        Queue<Task> allTasks = new PriorityQueue<>(
            Comparator.comparingInt(Task::getEnqueueTime).thenComparing(processingTimeThenIndex)
        );
        // availableTasks contains currently available tasks and is sorted by processing time and index
        Queue<Task> availableTasks = new PriorityQueue<>(processingTimeThenIndex);

        // Add tasks to the allTasks queue
        for (int i = 0; i < tasks.length; i++) {
            int[] taskInfo = tasks[i];
            Task task = new Task(taskInfo[0], taskInfo[1], i);
            allTasks.offer(task);
        }

        int virtualTime = 0;
        int orderCounter = 0;
        int[] order = new int[tasks.length];

        while (!allTasks.isEmpty() || !availableTasks.isEmpty()) {
            Task nextTask;
            if (availableTasks.isEmpty()) {
                // If there are no available tasks, pick the next task from allTasks
                nextTask = allTasks.poll();
                virtualTime = nextTask.getEnqueueTime();
            } else {
                // Pick the next available task
                nextTask = availableTasks.poll();
            }
            order[orderCounter++] = nextTask.getIndex();
            virtualTime += nextTask.getProcessingTime();

            // Add tasks that become available to the availableTasks queue
            while (!allTasks.isEmpty() && allTasks.peek().getEnqueueTime() <= virtualTime) {
                availableTasks.offer(allTasks.poll());
            }
        }

        return order;

    }
}

class Task {
    final int enqueueTime;
    final int processingTime;
    final int index;

    public Task(
            final int enqueueTime,
            final int processingTime,
            final int index) {
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
        this.index = index;
    }

    public int getEnqueueTime() {
        return enqueueTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public int getIndex() {
        return index;
    }
   
    }


