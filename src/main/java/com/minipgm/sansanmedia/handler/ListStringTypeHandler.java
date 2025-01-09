package com.minipgm.sansanmedia.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListStringTypeHandler extends BaseTypeHandler<List<String>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(java.sql.PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws java.sql.SQLException {
        try {
            // 将 List<String> 转换为 JSON 字符串
            String json = objectMapper.writeValueAsString(parameter);
            ps.setString(i, json);
        } catch (IOException e) {
            throw new java.sql.SQLException("Error serializing List<String>", e);
        }
    }

    @Override
    public List<String> getNullableResult(java.sql.ResultSet rs, String columnName) throws java.sql.SQLException {
        try {
            // 从数据库中读取 longtext 字段
            String json = rs.getString(columnName);
            if (json == null || json.isEmpty()) {
                return new ArrayList<>();
            }
            // 将 JSON 字符串反序列化为 List<String>
            return objectMapper.readValue(json, new TypeReference<List<String>>() {});
        } catch (IOException e) {
            throw new java.sql.SQLException("Error deserializing List<String>", e);
        }
    }

    @Override
    public List<String> getNullableResult(java.sql.ResultSet rs, int columnIndex) throws java.sql.SQLException {
        try {
            String json = rs.getString(columnIndex);
            if (json == null || json.isEmpty()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(json, new TypeReference<List<String>>() {});
        } catch (IOException e) {
            throw new java.sql.SQLException("Error deserializing List<String>", e);
        }
    }

    @Override
    public List<String> getNullableResult(java.sql.CallableStatement cs, int columnIndex) throws java.sql.SQLException {
        try {
            String json = cs.getString(columnIndex);
            if (json == null || json.isEmpty()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(json, new TypeReference<List<String>>() {});
        } catch (IOException e) {
            throw new java.sql.SQLException("Error deserializing List<String>", e);
        }
    }
}
