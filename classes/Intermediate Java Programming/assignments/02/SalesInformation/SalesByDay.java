import java.util.Scanner;
/**
 * Write a description of class SalesByDay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SalesByDay
{
    public static void main(String[] args) 
    {
        String inputDay = "";
        int dayIndex = 0;
        int saveIndex = 0;
        double inputAmt = 0.0;
        double saveAmt = 0.0;
        double[] dailySales = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        Scanner keyInput = new Scanner(System.in);
        
        System.out.print("Enter a day of the week (Su, Mo, Tu, We, Th, Fr, Sa) or Q to quit: ");
        inputDay = keyInput.next().trim().toUpperCase();
        keyInput.nextLine();
        
        while(!inputDay.equals("Q")) 
        {
            if(inputDay.equals("SU"))
                dayIndex = 0;
            else if(inputDay.equals("MO"))
                dayIndex = 1;
            else if(inputDay.equals("TU"))
                dayIndex = 2;
            else if(inputDay.equals("WE"))
                dayIndex = 3;
            else if(inputDay.equals("TH"))
                dayIndex = 4;
            else if(inputDay.equals("FR"))
                dayIndex = 5;
            else if(inputDay.equals("SA"))
                dayIndex = 6;
            else
            {
                System.out.print("\nInvalid day. Try again: ");
                inputDay = keyInput.next().trim().toUpperCase();
                keyInput.nextLine();
                continue;
            }
            
            do 
            {
                System.out.print("Enter a sale amount: ");
                if(keyInput.hasNextDouble())
                {
                    inputAmt = keyInput.nextDouble();
                    keyInput.nextLine();
                }
                else
                {
                    inputAmt = 0.0;
                    keyInput.nextLine();
                }
                
                if(inputAmt > 0.0)
                    dailySales[dayIndex] += inputAmt;
                else
                    System.out.println("Invalid Amount. Try again.");
            } while (inputAmt <= 0.0);
            
            System.out.println("\n\nSunday Sales = $" + dailySales[0] +
                                "\nMonday Sales = $" + dailySales[1] +
                                "\nTuesday Sales = $" + dailySales[2] +
                                "\nWednesday Sales = $" + dailySales[3] +
                                "\nThursday Sales = $" + dailySales[4] +
                                "\nFriday Sales = $" + dailySales[5] +
                                "\nSaturday Sales = $" + dailySales[6] + "\n\n");
                                
            for(dayIndex = 0; dayIndex < 7; dayIndex++)
            {
                if(dailySales[dayIndex] > saveAmt)
                {
                    saveAmt = dailySales[dayIndex];
                    saveIndex = dayIndex;
                }
            }
            
            switch(saveIndex)
            {
                case 0: System.out.println("The best day was Sunday with sales of $" + saveAmt);
                        break;
                case 1: System.out.println("The best day was Monday with sales of $" + saveAmt);
                        break;
                case 2: System.out.println("The best day was Tuesday with sales of $" + saveAmt);
                        break;
                case 3: System.out.println("The best day was Wednesday with sales of $" + saveAmt);
                        break;
                case 4: System.out.println("The best day was Thursday with sales of $" + saveAmt);
                        break;
                case 5: System.out.println("The best day was Friday with sales of $" + saveAmt);
                        break;
                case 6: System.out.println("The best day was Saturday with sales of $" + saveAmt);
                        break;
            }
        }
    }
}
