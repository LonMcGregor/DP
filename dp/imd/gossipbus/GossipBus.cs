//Challenge 264I - Gossipping Bus Drivers
//https://redd.it/4gqm90

namespace uk.lonm.dp.imd{

using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

class RunGossip {
    public static void Main(string[] args){
        GossippingSimulation gs = new GossippingSimulation();
        gs.readInputs();
        int count = gs.simulateUntilComplete();
        string message = count>=0 ? count.ToString() : "never";
        Console.WriteLine(message);
    }
}

class GossippingSimulation {
    private const int MAX_TIMESTEPS = 480;
    private const int TIMESTEP_BETWEEN_STOPS = 1;
    
    private List<GossippingBusDriver> drivers;
    private List<int> stops;
    
    public void readInputs(){
        Console.Write("How many Bus Drivers are there? =>");
        int numberOfDrivers = Convert.ToInt32(Console.ReadLine());
        this.drivers = new List<GossippingBusDriver>();
        this.stops = new List<int>();
        for(int i = 0; i < numberOfDrivers; i++){
            Console.Write("Route for driver {0}? =>", i);
            string route = Console.ReadLine();
            GossippingBusDriver newDriver = new GossippingBusDriver(numberOfDrivers, i, route);
            this.drivers.Add(newDriver);
            Console.WriteLine(" - Registered Driver {0} of {1} at {2}", i, numberOfDrivers, this.drivers.IndexOf(newDriver));
            Console.WriteLine(" - Driver {0} has route {1}", i, this.drivers[i].routeAsString());
            addRouteStops(route);
        }
    }
    
    private void addRouteStops(string route){
        Regex r = new Regex(@"\d+");
        foreach(Match m in r.Matches(route)){
            int stop = Convert.ToInt32(m.Value);
            if(!this.stops.Contains(stop)){
                this.stops.Add(stop);
                Console.WriteLine("Added new stop, Name:{0} Index:{1}", stop, this.stops.IndexOf(stop));
            }
        }
    }
    
    private bool checkDriversForGossip(){
        foreach(GossippingBusDriver d in this.drivers){
            if(!d.getAllGossip())return false;
        }
        return true;
    }
    
    private void simulateOneStep(){
        Console.WriteLine(" - Adding Drivers To Stops");
        List<int>[] driversAtStops = new List<int>[this.stops.Count];
        for(int i = 0; i < driversAtStops.Length; i++){
            driversAtStops[i] = new List<int>();
            Console.WriteLine(" - - Stop {0} Initialized", this.stops[i]);
        }
        foreach(GossippingBusDriver d in this.drivers){
            Console.WriteLine(" - - Driver {0} is at Stop {1}", d.getDriverID(), d.getCurrentStop());
            driversAtStops[this.stops.IndexOf(d.getCurrentStop())].Add(d.getDriverID());
            Console.WriteLine(" - - Driver Registered at Stop");
        }
        Console.WriteLine(" - Drivers Added To Stops");
        Console.WriteLine(" - Sharing Gossip");
        foreach(List<int> stop in driversAtStops){
            foreach(int driverID in stop){
                Console.WriteLine(" - - Driver {0} is receiving gossip", driverID);
                foreach(int otherDriverID in stop){
                    this.drivers[driverID].updateGossip(this.drivers[otherDriverID].getKnownGossip());
                    Console.WriteLine(" - - - Driver {0} Learned Gossip From Driver {1}", driverID, otherDriverID);
                }
            }
        }
        Console.WriteLine(" - Gossip Shared");
        Console.WriteLine(" - Moving Drivers");
        foreach(GossippingBusDriver d in this.drivers){
            d.advanceBusStop();
            Console.WriteLine(" - - Driver {0} Moved", d.getDriverID());
        }
        Console.WriteLine(" - Drivers moved to next spot");
    }
    
    public int simulateUntilComplete(){
        for(int i = 0; i < MAX_TIMESTEPS; i++){
            Console.WriteLine("Simulating Timestep {0}", i);
            if(checkDriversForGossip())return i;
            simulateOneStep();
        }
        return -1;
    } 
}

class GossippingBusDriver {
    private int driverID;
    private bool[] knownGossip;
    private bool hasAllGossip;
    private List<int> route;
    private int currentStop;
    
    public GossippingBusDriver(int totalDrivers, int currentID, string newRoute){
        this.driverID = currentID;
        initKnownGossip(totalDrivers);
        updateGossip(currentID);
        setRoute(newRoute);
        this.currentStop = 0;
        Console.WriteLine(" - - Driver {0} initialized, starting at stop {1} in {2}", this.driverID, this.currentStop, routeAsString());
    }
    
    private void initKnownGossip(int totalDrivers){
        this.knownGossip = new bool[totalDrivers];
        for(int i = 0; i < totalDrivers; i++){
            this.knownGossip[i] = false;
        }
        this.knownGossip[this.driverID] = true;
    }
    
    private void setRoute(string route){
        Regex r = new Regex(@"\d+");
        this.route = new List<int>();
        foreach(Match m in r.Matches(route)){
            this.route.Add(Convert.ToInt32(m.Value));
        }
    }
    
    public void updateGossip(int driver){
        this.knownGossip[driver] = true;
        foreach(bool b in knownGossip){
            if(!b)return;
        }
        this.hasAllGossip = true;
    }
    
    public void updateGossip(bool[] newGossip){
        for(int i = 0; i < newGossip.Length; i++){
            this.knownGossip[i] = this.knownGossip[i] || newGossip[i];
            if(newGossip[i]) Console.WriteLine(" - - - - Driver {0} now knows Gossip of {1}", this.driverID, i);
        }
        updateGossip(this.driverID);
    }
    
    public void advanceBusStop(){
        this.currentStop = (this.currentStop + 1) % this.route.Count;
    }
    
    public bool getAllGossip(){return this.hasAllGossip;}
    public bool[] getKnownGossip(){return this.knownGossip;}
    public int getCurrentStop(){return this.route[this.currentStop];}
    public int getDriverID(){return this.driverID;}
    public string routeAsString(){
        string s = "";
        foreach(int r in this.route){
            s += r.ToString();
            s += " ";
        }
        return s;
    }
}


}