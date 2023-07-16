using Assignment1CSharp.Models;
using Assignment1CSharp.UnitOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment1CSharp.Controllers
{
    // Ly do minh can goi tu Repository sang Controller la de thuan tien cho viec viet Test sau nay
    // Controller chi can goi lai cac ham da viet trong Respository
    public class CustomerController
    {
        private readonly IUnitOfWork _unitOfWork;
        public CustomerController(IUnitOfWork unitOfWork)
        {
            _unitOfWork = unitOfWork;
        }

        public void Add(Customer entity)
        {
            _unitOfWork.CustomerRepository.Add(entity);
            _unitOfWork.Save();
            Console.WriteLine("Create Success");
        }

        public void Delete(int id)
        {
            try
            {
                _unitOfWork.CustomerRepository.Delete(id);
                _unitOfWork.Save();
                Console.WriteLine("Delete Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Delete failed: " + ex.Message);
            }
        }

        public List<Customer> GetAll()
        {
            return _unitOfWork.CustomerRepository.GetAll();
        }

        public Customer GetById(int id)
        {
            return _unitOfWork.CustomerRepository.GetById(id);
        }

        public void Update(int id, Customer entity)
        {
            try
            {
                _unitOfWork.CustomerRepository.Update(id, entity);
                _unitOfWork.Save();
                Console.WriteLine("Update Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Update failed: " + ex.Message);
            }
        }
    }
}
