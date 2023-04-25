package com.socksmarker.socksmarket.service;

import com.socksmarker.socksmarket.model.Sock;
import com.socksmarker.socksmarket.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {
    @Autowired
    MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    // Метод добавляет сущность Sock  в базу данных
    public Sock addSocks(Sock sock) {
        return marketRepository.save(sock);
    }

    // Метод удаляет сущность Sock из базы данных
    public Sock removeSocks(Sock sock) {
        marketRepository.delete(sock);
        return sock;
    }

    // Метод возвращает список сущностей Sock, где cottonPart больше переданного значения
    public List<Sock> getSocksWithCottonMoreThan(Integer cottonPart, String colour) {
        List<Sock> socks = marketRepository.findAll();
        List<Sock> result = new ArrayList<>();
        int i = 0;
        for (Sock sock : socks) {
            if (sock.getCottonPart() > cottonPart && sock.getColour().equals(colour)) {
                result.add(i++, sock);
                return result;
            } else System.out.println("Не найдено");
        }
        return result;
    }

    // Метод возвращает список сущностей Sock, где cottonPart меньше переданного значения
    public List<Sock> getSocksWithCottonLessThan(Integer cottonPart, String colour) {
        List<Sock> socks = marketRepository.findAll();
        List<Sock> result = new ArrayList<>();
        int i = 0;
        for (Sock sock : socks) {
            if (sock.getCottonPart() < cottonPart && sock.getColour().equals(colour)) {
                result.add(i++, sock);
                return result;
            } else System.out.println("Не найдено");
        }
        return result;
    }

    // Метод возвращает список сущностей Sock, где cottonPart равен переданному значению
    public List<Sock> getSocksWithCottonEquals(Integer cottonPart, String colour) {
        List<Sock> socks = marketRepository.findAll();
        List<Sock> result = new ArrayList<>();
        int i = 0;
        for (Sock sock : socks) {
            if (sock.getCottonPart() == cottonPart && sock.getColour().equals(colour)) {
                result.add(i++, sock);
                return result;
            } else System.out.println("Не найдено");
        }
        return result;
    }
}
