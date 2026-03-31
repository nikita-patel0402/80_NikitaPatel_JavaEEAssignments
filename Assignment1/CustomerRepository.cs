using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_1
{
    internal class CustomerRepository : IRepostiory<CustomerClass>
    {
        private CustomerClass _customerClass;

        public void add(CustomerClass customer)
        {
            _customerClass = customer;
            Console.WriteLine($"Customer added: {customer.Name}");
        }

        public CustomerClass get()
        {
            return _customerClass;
        }
    }
}
