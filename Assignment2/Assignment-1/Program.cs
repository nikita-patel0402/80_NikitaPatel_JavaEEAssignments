// See https://aka.ms/new-console-template for more information
//Console.WriteLine("Hello, World!");

using Assignment_1;

//Console.WriteLine("*** Datatype :- integer ***");
//Console.WriteLine();
//Console.Write("Enter the Value1 :- ");
//int val1 = Convert.ToInt32(Console.ReadLine());
//Console.Write("\n");
//Console.Write("Enter the Value2 :- ");
//int val2 = Convert.ToInt32(Console.ReadLine());
//Console.Write("\n");

//Que1<int> question1 = new Que1<int>(val1,val2);

//Console.WriteLine("\n");
//Console.WriteLine("Addition of two values      :- "+question1.add());
//Console.WriteLine("Substraction of two values  :- "+question1.substaction());
//Console.WriteLine("Multiplicaton of two values :- "+question1.multiplication());
//Console.WriteLine("Division of two values      :- "+question1.Division());
//Console.WriteLine("===============================================================");
//Console.WriteLine();

//Console.WriteLine("*** Datatype :- double ***");
//Console.WriteLine();
//Console.Write("Enter the Value1 :- ");
//double val3 = Convert.ToDouble(Console.ReadLine());
//Console.Write("\n");
//Console.Write("Enter the Value2 :- ");
//double val4 = Convert.ToDouble(Console.ReadLine());
//Console.Write("\n");
//Que1<double> question2_double = new Que1<double>(val3, val4);
//Console.WriteLine("\n");
//Console.WriteLine("Addition of two values      :- " + question2_double.add());
//Console.WriteLine("Substraction of two values  :- " + question2_double.substaction());
//Console.WriteLine("Multiplicaton of two values :- " + question2_double.multiplication());
//Console.WriteLine("Division of two values      :- " + question2_double.Division());
//Console.WriteLine("===============================================================");

//var crud = new Que3<int>();
//int choice,values,pos;


//do {
//    Console.WriteLine("\n\n");
//    Console.WriteLine("1.Insert Element");
//    Console.WriteLine("2.Delete Element");
//    Console.WriteLine("3.Display Element");
//    Console.WriteLine("4.Update Element");
//    Console.WriteLine("5.Search Element");
//    Console.WriteLine("------------------------------");
//    Console.Write("Enter your choice :-");
//    choice=Convert.ToInt32(Console.ReadLine());

//    switch(choice)
//    {
//        case 1:
//            Console.WriteLine();
//            Console.Write("Enter the Element :-");
//            values = Convert.ToInt32(Console.ReadLine());
//            crud.insert(values);
//            break;

//        case 2:
//            Console.WriteLine();
//            Console.Write("Enter the Element you want Remove :-");
//            values = Convert.ToInt32(Console.ReadLine());
//            crud.delete(values);
//            break;

//        case 3:
//            Console.WriteLine();
//            crud.display();
//            break;


//        case 4:
//            Console.WriteLine();
//            Console.Write("Enter the position you want to update :-");
//            pos= Convert.ToInt32(Console.ReadLine());
//            if (pos > crud.items.Count)
//            {
//                Console.WriteLine("There is no Element on that position");
//            }
//            else
//            {
//                Console.Write("Enter the Updated Element :-");
//                values = Convert.ToInt32(Console.ReadLine());
//                crud.update(values, pos);
//            }
           
//            break;

//        case 5:
//            Console.WriteLine();
//            Console.Write("Enter the Element you want to search :-");
//            pos= Convert.ToInt32(Console.ReadLine());
//            crud.search(pos);
//            break;
//    }

//} while(choice!=6);





IRepostiory<ProductClass> productRepo = new ProductRepository();
productRepo.add(new ProductClass { Name = "Tablet" });
ProductClass product = productRepo.get();
Console.WriteLine($"Retrieved product: {product.Name}");
    
Console.WriteLine();
IRepostiory<CustomerClass> customerRepo = new CustomerRepository();
customerRepo.add(new CustomerClass { Name = "Nikita Patel" });
CustomerClass customer = customerRepo.get();
Console.WriteLine($"Retrieved customer: {customer.Name}");


Console.ReadLine();