/* Practical 1
Create a class named weather report that holds a daily weather report with
data members day_of_month, hightemp, lowtemp,a mount_rain and
amount_snow. Use different types of constructors to initialize the objects.
Also include a function that prompts the user and sets values for each field
so that you can override the default values. Write a menu driven program
in C++ with options to enter data and generate monthly report that displays
average of each attribute
*/

#include<iostream>
using namespace std;
class weather_report{
	public:
		int dom;
		float hightemp,lowtemp,amt_rain,amt_snow;
		weather_report(){
			dom=0;
			hightemp=0;
			lowtemp=0;
			amt_rain=0;
			amt_snow=0;
		}
		void input(int day){
			dom=day;
			cout<<"\nEnter High Tempreture : ";
			cin>>hightemp;
			cout<<"\nEnter Low Tempreture : ";
			cin>>lowtemp;
			cout<<"\nEnter Rain Percentage :";
			cin>>amt_rain;
			cout<<"\nEnter Snow Percentage :";
			cin>>amt_snow;
		}
		void output(){
			cout<<dom<<"\t"<<hightemp<<"\t"<<lowtemp<<"\t"<<amt_rain<<"%\t"<<amt_snow<<"%\n";
		}
	
};
 int main(){
 	int month,days,ch;
 	float high=0,low=0,rain=0,snow=0;
 	//weather_report data[12][31];
 	weather_report data[5][5];
 	cout<<"\nEnter Month : ";
 	cin>>month;
 	cout<<"\nEnter Days: ";
 	cin>>days;
 	/*if(month==1||month==3||month==7||month==8||month==10||month==12){
 		days=31;
	 }
	 else if(month==2){
	 	cout<<"\nEnter Days: ";
	 	cin>>days;
	 	if(days!=28 && days!=29){
	 		cout<<"\nEnter Valid Choice";
	 		return 0;
		 } 
	 }
	 else{
	 	days = 30;
	 }*/
	 
	 do{
	 	cout<<"\n1.Enter Data\n2.Display Daily Data\n3.Display Report\n4.Exit";
	 	cout<<"\nEnter Your Choice : ";
	 	cin>>ch;
	 	switch(ch){
	 		case 1:
	 			for(int i=1;i<=days;i++){
	 				cout<<"\nDay "<<i<<":\n";
	 				data[month][i].input(i);
				 }
				 break;
		    case 2:
		    	cout<<"\nDay\tHigh\tLow\tRain\tSnow\n";
		    	for(int i=1;i<=days;i++){
		    		data[month][i].output();
				}
				break;
			case 3:
				cout<<"\tDay\tHigh\tLow\tRain\tSnow\n";
				for(int i=1;i<=days;i++){
					data[month][i].output();
				}
				for(int i=1;i<=days;i++){
					high=high+data[month][i].hightemp;
					low=low+data[month][i].lowtemp;
					rain=rain+data[month][i].amt_rain;
					snow=snow+data[month][i].amt_snow;
				}
				cout<<"\nAverage High Tempreture: "<<high/days;
				cout<<"\nAverage Low Tempreture: "<<low/days;
				cout<<"\nAverage Rain Tempreture: "<<rain/days<<"%";
				cout<<"\nAverage Snow Percentage: "<<snow/days<<"%\n\n";
				break;
			case 4:
					break;
			default:
				cout<<"\nEnter Valid Choice";
				break;
				
		 }
	 }while(ch!=4);
	 return 0;
}
