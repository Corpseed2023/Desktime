package com.example.desktime.serviceimpl;

import com.example.desktime.ApiResponse.UserNotFoundException;
import com.example.desktime.model.IPAccess;
import com.example.desktime.model.User;
import com.example.desktime.repository.IpAccessRepository;
import com.example.desktime.repository.UserRepository;
import com.example.desktime.service.IpAccessService;
import org.bouncycastle.util.IPAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IpAccessServiceImpl implements IpAccessService {

    @Autowired
    private IpAccessRepository ipAccessRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addIpAddress(Long userId, String ipAddress) {
        Optional<User> userOptional = userRepository.findById(userId);

        User user = userOptional.orElseThrow(() -> new UserNotFoundException());

        boolean isAdmin = user.getRoles().stream().anyMatch(role -> role.getRoleName().equals("ADMIN"));

        if (isAdmin==true) {
            IPAccess ipAccess = new IPAccess();
            ipAccess.setNetworkIpAddress(ipAddress);
            ipAccess.setUser(user);
            ipAccessRepository.save(ipAccess);
        } else {
            throw new IllegalStateException("User is not an admin");
        }
        return ipAddress;
    }

    public String getCheckIp(String ipAddress) {

        IPAccess ipAccess = ipAccessRepository.findByNetworkIpAddress(ipAddress);

        if (ipAccess != null) {

            return ipAccess.getNetworkIpAddress();
        } else {
            return "IP Address not found";
        }
    }


    @Override
    public List<IPAccess> getIps(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        User user = userOptional.orElseThrow(() -> new UserNotFoundException());
        
        List<IPAccess> ips = ipAccessRepository.findAll();
        
        return ips;
    }

}
