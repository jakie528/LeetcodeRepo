class Logger {
    HashMap<String, Integer> log;
    private int ttl = 10;

    public Logger() {
        log = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {

        // print at most once every 10 seconds.
        // t=11 > t=3
        if(log.containsKey(message) && log.get(message)> timestamp){
            return false;
        }

        log.put(message, timestamp + ttl);

        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */