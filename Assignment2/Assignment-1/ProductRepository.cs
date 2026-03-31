using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_1
{
    internal class ProductRepository : IRepostiory<ProductClass>
    {
        private ProductClass _productClass;

        public void add(ProductClass product)
        {
            _productClass = product;
            Console.WriteLine("Product is added");
        }

        public ProductClass get()
        {
            return _productClass;
        }
    }
}
