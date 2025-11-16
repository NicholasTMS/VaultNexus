package com.kallavaninc.vaultnexus.service;

import com.kallavaninc.vaultnexus.DTO.UserDTO.UserRequestDTO;
import com.kallavaninc.vaultnexus.DTO.UserDTO.UserResponseDTO;
import com.kallavaninc.vaultnexus.entity.User;
import com.kallavaninc.vaultnexus.mapper.UserMapper;
import com.kallavaninc.vaultnexus.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        // e.g. hash password, set defaults
        User saved = userRepository.save(user);
        return userMapper.toResponseDto(saved);
    }

    @Transactional(readOnly = true)
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
        return userMapper.toResponseDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
        existing.setUsername(dto.getUsername());
        existing.setEmail(dto.getEmail());
        // optionally update password, etc.
        User saved = userRepository.save(existing);
        return userMapper.toResponseDto(saved);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}