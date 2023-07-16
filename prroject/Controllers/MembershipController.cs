using Assignment1CSharp.Models;
using Assignment1CSharp.UnitOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment1CSharp.Controllers
{
    public class MembershipController
    {
        private readonly IUnitOfWork _unitOfWork;
        public MembershipController(IUnitOfWork unitOfWork)
        {
            _unitOfWork = unitOfWork;
        }

        public void Add(Membership entity)
        {
            _unitOfWork.MembershipRepository.Add(entity);
            _unitOfWork.Save();
            Console.WriteLine("Add success");
        }

        public void Delete(int id)
        {
            try
            {
                _unitOfWork.MembershipRepository.Delete(id);
                _unitOfWork.Save();
                Console.WriteLine("Delete success");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Delete failed: " + ex.Message);
            }
        }

        public List<Membership> GetAll()
        {
            return _unitOfWork.MembershipRepository.GetAll();
        }

        public Membership GetById(int id)
        {
            return _unitOfWork.MembershipRepository.GetById(id);
        }

        public void Update(int id, Membership entity)
        {
            try
            {
                _unitOfWork.MembershipRepository.Update(id, entity);
                _unitOfWork.Save();
                Console.WriteLine("Update success");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Update failed: " + ex.Message);
            }
        }
    }
}
