using Assignment1CSharp.Models;
using Assignment1CSharp.UnitOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment1CSharp.Controllers
{
    public class ProductController
    {
        private readonly IUnitOfWork _unitOfWork;
        public ProductController(IUnitOfWork unitOfWork)
        {
            _unitOfWork = unitOfWork;
        }

        public void Add(Product entity)
        {

            _unitOfWork.ProductRepository.Add(entity);
            _unitOfWork.Save();
            Console.WriteLine("Add success");
        }

        public void Delete(int id)
        {
            try
            {
                _unitOfWork.ProductRepository.Delete(id);
                _unitOfWork.Save();
                Console.WriteLine("Delete success");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Delete failed: " + ex.Message);
            }
        }

        public List<Product> GetAll()
        {
            return _unitOfWork.ProductRepository.GetAll();
        }

        public Product GetById(int id)
        {
            return _unitOfWork.ProductRepository.GetById(id);
        }

        public void Update(int id, Product entity)
        {
            try
            {
                _unitOfWork.ProductRepository.Update(id, entity);
                _unitOfWork.Save();
                Console.WriteLine("Delete success");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Update failed: " + ex.Message);
            }
        }
    }
}
