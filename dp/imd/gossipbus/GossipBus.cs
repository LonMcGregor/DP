//Challenge 264I - Gossipping Bus Drivers, + bonus

namespace uk.lonm.dp.imd{

using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

class RunGossip {
    public static void Main(string[] args){
        GossippingSimulation gs = new GossippingSimulation();
        gs.readInputs();
        gs.simulateUntilComplete();
    }
}

class GossippingSimulation {
    private const int MAX_TIMESTEPS = 480;
    private const int TIMESTEP_BETWEEN_STOPS = 1;
    private const bool USE_TIMESTEP_TO_GOSSIP = false; //f default, t For bonus
    
    private List<GossippingBusDriver> drivers;
    private List<int> stops;
    private List
    
    public void readInputs(){
        Console.Write("How many Bus Drivers are there? =>");
        int numberOfDrivers = Convert.ToInt32(Console.ReadLine());
        this.drivers = new List<GossippingBusDriver>();
        this.stops = new List<int>();
        for(int i = 0; i < numberOfDrivers; i++){
            Console.Write("Route for driver {0}? =>", i);
            string route = Console.ReadLine();
            drivers.Add(new GossippingBusDriver(numberOfDrivers, i, route));
            addRouteStops(route);
        }
    }
    
    private void addRouteStops(string route){
        Regex r = new Regex(@"\d+");
        foreach(Match m in r.Matches(route)){
            int stop = Convert.ToInt32(m.Value);
            if(!this.stops.Contains(stop)){
                this.stops.Add(stop);
            }
        }
    }
    
    private bool checkDriversForGossip(){
        foreach(GossippingBusDriver d in drivers){
            if(!d.getAllGossip())return false;
        }
        return true;
    }
    
    public void simulateOneStep(){
        //for each bus stop
            //make a list
        //for each driver
            //add to list of bus stop
        //for each stop in bust stop list
        //for each driver, update gossip for each other driver
        //for each bus driver
            //advance bus stop
    }
    
    public int simulateUntilComplete(){
        for(int i = 0; i < MAX_TIMESTEPS; i++){
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
    
    public GossippingBusDriver(int totalDrivers, int currentID, string route){
        this.driverID = currentID;
        initKnownGossip(totalDrivers);
        updateGossip(currentID);
        setRoute(route);
        this.currentStop = route.Get(0);
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
    
    private void updateGossip(int driver){
        this.knownGossip[driver] = true;
        foreach(bool b in knownGossip){
            if(!b)return;
        }
        this.hasAllGossip = true;
    }
    
    private void advanceBusStop(){
        this.currentStop = (this.currentStop + 1) % this.route.Count();
    }
    
    public List<int> getRoute(){return this.route;}
    public bool getAllGossip(){return this.hasAllGossip;}
    public int getCurrentStop(){return this.route.Get(this.currentStop());}
}

}